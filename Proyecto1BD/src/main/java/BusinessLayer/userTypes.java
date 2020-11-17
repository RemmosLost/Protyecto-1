/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

/**
 *
 * @author David B
 */
public enum userTypes {
    adminUser,regularUser;
    
    public userTypes getUserTypes(int value){
        switch(value) {
            case 0:
                return adminUser;
            case 1:
                return regularUser;
        }
        return null;
    }
    
    public userTypes getUserTypes(String value){
        switch(value.toLowerCase()) {
            case "administrator":
                return adminUser;
            case "regular":
                return regularUser;
        }
        return null;
    }

    @Override
    public String toString() {
        return "userTypes{" +"adminUser, "+ "regularUser"+ '}';
    }
    
    
}
