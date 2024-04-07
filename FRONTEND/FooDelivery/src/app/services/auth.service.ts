
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../services/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'https://foodelivery-d2d7a5204308.herokuapp.com';
  private tokenKey = 'jwt_token';
  private isLoggedInSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isLoggedIn: Observable<boolean> = this.isLoggedInSubject.asObservable();

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/users/auth`, { email, password });
  }

  setToken(token: string): void {
    if (typeof localStorage !== 'undefined') {
      localStorage.setItem(this.tokenKey, token);
      this.isLoggedInSubject.next(true);
    }
  }

  getToken(): string | null {
    if (typeof localStorage !== 'undefined') {
      return localStorage.getItem(this.tokenKey);
    }
    return null;
  }

  removeToken(): void {
    if (typeof localStorage !== 'undefined') {
      localStorage.removeItem(this.tokenKey);
      this.isLoggedInSubject.next(false);
    }
  }

  addTokenToHeaders(): HttpHeaders {
    const token = this.getToken();
    if (token) {
      return new HttpHeaders({
        'Authorization': `Bearer ${token}`
      });
    } else {
      return new HttpHeaders();
    }
  }

  getUserProfile(): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/users/me`, { headers: this.addTokenToHeaders() });
  }

  updateUserProfile(user: User): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/users/me`, user, { headers: this.addTokenToHeaders() });
  }

}
