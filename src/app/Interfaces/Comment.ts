import { Article } from "./Article";
import { User } from "./User";


export interface Comment {
    id?: number;
    content: string;
    date?: Date;
    user?: Partial<User>;
    article: Partial<Article>;
}
