import { Subject } from "./Subject";
import { User } from "./User";


export interface Article {
    id: number;
    title: string;
    content: string;
    date: Date;
    subject: Subject;
    user: User;
}
