import { Article } from "./Article";
import { User } from "./User";

export interface Subscription {
    id: number;
    user: User;  // Utilisateur abonné
    article: Article;  // Article auquel l'utilisateur est abonné
    dateOfSubscription: Date;
    dateOfUnSubscription?: Date;  // Optionnel si non encore désabonné
}
