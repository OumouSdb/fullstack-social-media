import { Article } from "./Article";
import { Subject } from "./Subject";
import { User } from "./User";

export interface Subscription {
    id: number;
    user: User;
    article: Article;
    subject: Subject;
}
