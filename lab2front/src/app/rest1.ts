import { Weather } from "./weather";

export interface Rest1 {
    _embedded: {
        weathers: Weather[]
        },
        _links: {
        self: {
        href: string;
        },
        profile: {
        href: string;
        }
        },
        
        page: {
        size: number,
        totalElements: number,
        totalPages: number,
        number: number
        }

}