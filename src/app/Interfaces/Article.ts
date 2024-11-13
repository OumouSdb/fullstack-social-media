import { Subject } from "./Subject";
import { User } from "./User";


export interface Article {
    author: any;
    id: string;
    title: string;
    content: string;
    date: Date;
    subject: Subject;
    user: User;
}
