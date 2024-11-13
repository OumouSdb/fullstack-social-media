export interface LoginResponse {
    id: number;
    firstname: string;
    lastname: string;
    email: string;
    createdAt: Date;
    updatedAt: Date;
    token: string;
    role: string;
}
