import java.util.*;

public class Problem {
    private final Depot[] depots;
    private Client[] clients;

    public Problem(Depot... depots) {
        this.depots = depots;
    }

    /**
     * Retrieves all vehicles from all depots.
     *
     * @return Array of all vehicles from all depots.
     */
    public Vehicle[] getVehicles() {
        int numberOfVehicles = 0;
        for (Depot depot : depots)
            numberOfVehicles += depot.getVehicles().length;
        Vehicle[] result = new Vehicle[numberOfVehicles];
        int index = 0;
        for (Depot depot : depots)
            for (Vehicle vehicle : depot.getVehicles())
                result[index++] = vehicle;
        return result;
    }

    /**
     * Allocates clients to vehicles using a simple greedy algorithm.
     *
     * @param clients The list of clients to allocate.
     */
    public void allocateClients(List<Client> clients) {
        Vehicle[] vehicles = getVehicles();
        Map<Vehicle, List<Client>> vehicleAllocations = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            vehicleAllocations.put(vehicle, new ArrayList<>());
        }

        // Greedy allocation
        Iterator<Client> clientIterator = clients.iterator();
        Iterator<Client> clientToRemove = null;
        while (clientIterator.hasNext()) {
            /**
             * Check and find the vehicle with enough space to get clients
             */
            Vehicle minLoadVehicle = null;
            double minLoad = Double.MAX_VALUE;
            for (Vehicle vehicle : vehicles) {
                double load = vehicleAllocations.get(vehicle).size();
                if (load < minLoad) {
                    minLoad = load;
                    minLoadVehicle = vehicle;
                }
            }
            /**
             * Check and find the client with the most efficient time
             */
            double minTimeClient = Double.MAX_VALUE;
            Client clientFound = null;
            while (clientIterator.hasNext()) {
                Client currentClient = clientIterator.next();
                double timeDepotToClient = currentClient.getTimeDepotToClient();
                double timeClientToClient = currentClient.getTimeClientToClient();

                if (timeDepotToClient < timeClientToClient) {
                    if (timeDepotToClient < minTimeClient) {
                        minTimeClient = timeDepotToClient;
                        clientFound = currentClient;
                        clientToRemove = clientIterator;
                    }
                } else {
                    if (timeClientToClient < minTimeClient) {
                        minTimeClient = timeClientToClient;
                        clientFound = currentClient;
                        clientToRemove = clientIterator;
                    }
                }
            }
            if (minLoadVehicle != null && clientFound != null) {
                vehicleAllocations.get(minLoadVehicle).add(clientFound);
                clientToRemove.remove(); // Remove the assigned client from the list
            }
        }

        // Print allocations
        for (Map.Entry<Vehicle, List<Client>> entry : vehicleAllocations.entrySet()) {
            System.out.println("Vehicle: " + entry.getKey());
            System.out.println("Clients: " + entry.getValue());
            System.out.println();
        }
    }
}
