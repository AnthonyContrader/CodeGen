import { EntityOwnerDTO } from './entityownerdto';
import { EntityCustomerDTO } from './entitycustomerdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend.
 * 
 * @author Salvatore Petrianni
 */
export class RelationshipDTO {

   id: number;

   entityowner: EntityOwnerDTO;

   entitycustomer: EntityCustomerDTO;

}

