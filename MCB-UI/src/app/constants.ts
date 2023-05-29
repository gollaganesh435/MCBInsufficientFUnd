import { HttpHeaders } from "@angular/common/http";

export const API_PREFIX = 'http://localhost:8080/';
export const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
export const LOCAL_TOKEN_KEY = 'token';
export const CURRENT_USER = 'currentUser';