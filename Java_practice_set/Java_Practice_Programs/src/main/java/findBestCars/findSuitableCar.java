package findBestCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class findSuitableCar {

    // Below Method used to filter by range / brand / Mileage and Rating the best car from given List<Car>
    public List<Car> findBestCars(List<Car> cars, double minPrice, double maxPrice, String preferredBrand, double maxMileage, double minRating) {
        return cars.stream()
                .filter(car -> car.price >= minPrice && car.price <= maxPrice)
                .filter(car -> preferredBrand == null || car.brand.equalsIgnoreCase(preferredBrand))
                .filter(car -> car.mileageInKM <= maxMileage)
                .filter(car -> car.rating >= minRating)
                .sorted(Comparator.comparingDouble(Car::getPrice)
                        .thenComparingDouble(Car::getRating).reversed()
                        .thenComparingDouble(Car::getMileageInKM))
                .collect(Collectors.toList());
    }

    //
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(1, 20000, "Honda", "City", 35000, 3.6),
                new Car(2, 25000, "Maruthi", "S-Cross", 20000, 4.0),
                new Car(3, 12000, "hyundai", "i20", 60000, 4.2),
                new Car(4, 18000, "TATA", "Punch", 45000, 4.6));

        findSuitableCar bestCar = new findSuitableCar();
        List<Car> suitableCar = bestCar.findBestCars(cars, 12000, 30000, "TATA", 46000, 3.5);

        StringBuilder outputString = new StringBuilder("Preferred car for the customer is::");
        for (Car car : suitableCar) {
            outputString.append(car).append("\n");
        }
        System.out.print(outputString);
    }

}
