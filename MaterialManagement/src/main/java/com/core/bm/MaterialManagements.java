package com.core.bm;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
* InventoryException is class for custome exception  & extends RuntimeException
* created parameterised consturctor with string msg
*  */
class InventoryException extends RuntimeException {
    public InventoryException(String msg) {
        super(msg);
    }

}

public class MaterialManagements {

    /*bomOfBiCycle is object of hashmap having Bill Of Material for Bicycle
    bomOfBrakeset is object of hashmap having Bill Of Material for Beake set
    bomOfHandInventory is object of hashmap having Bill Of Material for OnHandInventory
    */
    private static Map<String, Integer> bomOfBiCycle = new HashMap<>();
    private static Map<String, Integer> bomOfBrakeset = new HashMap<>();
    private static Map<String, Integer> bomOfHandInventory = new HashMap<>();

    static {

//initialize the Bicycle BOM with given data for 1 bicycle
        bomOfBiCycle.put("seat", 1);
        bomOfBiCycle.put("frame", 1);
        bomOfBiCycle.put("brake set", 2);
        bomOfBiCycle.put("handle bar", 1);
        bomOfBiCycle.put("wheel", 2);
        bomOfBiCycle.put("tire", 2);
        bomOfBiCycle.put("chain", 1);
        bomOfBiCycle.put("crank set", 1);
        bomOfBiCycle.put("Pedal", 2);

//initialze the Brakeset BOM with given data for brake set
        bomOfBrakeset.put("brake paddle", 1);
        bomOfBrakeset.put("brake cable", 1);
        bomOfBrakeset.put("lever", 1);
        bomOfBrakeset.put("brake shoe", 2);

//initialze the Onhand Inventory BOM with given data of available quantity
        bomOfHandInventory.put("seat", 50);
        bomOfHandInventory.put("frame", 80);
        bomOfHandInventory.put("brake set", 25);
        bomOfHandInventory.put("brake paddle", 100);
        bomOfHandInventory.put("brake cable", 75);
        bomOfHandInventory.put("lever", 60);
        bomOfHandInventory.put("brake shoe", 150);
        bomOfHandInventory.put("handle bar", 150);
        bomOfHandInventory.put("wheel", 60);
        bomOfHandInventory.put("tire", 80);
        bomOfHandInventory.put("chain", 100);
        bomOfHandInventory.put("crank set", 50);
        bomOfHandInventory.put("pedal", 150);

    }

    /* forTotalRequirements method for calculate requierement of given no of Bicycle
    * method is static to directly call into main method
    * finalRequirements is object of hashmap to store final requirements
    * */
    private static Map<String, Integer> forTotalRequirements(int numberOfBicycles)  {
        Map<String, Integer> finalRequirements = new HashMap<>();

      /*  Bicycle BOM iterates each entry & merge to finalRequirements
      * Here java 8 features added like lambda function, forEach to reduce lines of code
       */
        bomOfBiCycle.forEach((part, quantity) ->
                finalRequirements.merge(part, quantity * numberOfBicycles, Integer::sum));

       /* variable totalBrakeSets will catch brake set from bicycle BOM & Multiply to numberOfBicycles */
        int totalBrakeSets = bomOfBiCycle.get("brake set")* numberOfBicycles;

/*
* BOM of brake set iterates each entry and merge multiply into  finalRequirements
* Here java 8 features added like lambda function, forEach to reduce lines of code
 */
        bomOfBrakeset.forEach((key, value) ->
                finalRequirements.merge(key, value * totalBrakeSets, Integer::sum));

        return finalRequirements;

    }
    /* forNetTotalRequirements method for calculate final requierements for
     * method is static to directly call into main method
     * finalNetRequirements is object of hashmap to store final requirements
      */

    private static Map<String, Integer> forNetTotalRequirements(Map<String, Integer> totalRequirements) {
        Map<String, Integer> finalNetRequirements = new HashMap<>();

        /* totalRequirements iterates each entry
        * for onHandQuantity Optional class is used to avoid Nill Pointer Exception
        * Optinal Class is java 8 feature
        * netQuantity will substraction of requiredQuantity & onHandQuantity
        * */

        totalRequirements.forEach((part, requiredQuantity) -> {
            int onHandQuantity = Optional.ofNullable(bomOfHandInventory.get(part)).orElse(0);
            int netQuantity = requiredQuantity - onHandQuantity;


/*If required quantity more than Net Quantity then it will throw Inventory Exception
* InventoryException is custome exception
* Math.max(netQuantity, 0) will not take any negative quantity
*
* */
            if ( requiredQuantity < netQuantity ) {
                throw new InventoryException("Required quantity should not more than net quantity: " + part);
            }

            finalNetRequirements.put(part, Math.max(netQuantity, 0));
        });

        return finalNetRequirements;
    }


    public static void main(String[] args) throws InventoryException {

        int numberOfBicycle = 200;

        // calculate total requirements
        Map<String, Integer> totalRequirements = forTotalRequirements(numberOfBicycle);
        // calculate final net requirements
        Map<String, Integer> finalNetRequirement = forNetTotalRequirements(totalRequirements);

        // to print total requirement
        System.out.println("Total Requirement :");
        totalRequirements.forEach((part, quantity) ->
                System.out.println(part + ":" + quantity));

        // to print final net quantity
        System.out.println("Net Requirement :");
        finalNetRequirement.forEach((part, quantity) -> System.out.println(part + ":" + quantity));

    }
}

