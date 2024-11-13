import { Article } from "./Article";
import { User } from "./User";


export interface Comment {
    id: number;
    content: string;
    date: Date;
    user: User;  // Auteur du commentaire
    article: Article;  // Article auquel le commentaire est lié
}
