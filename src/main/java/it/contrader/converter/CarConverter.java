package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CarDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Car;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio, De Santis 
 *
 */
public class CarConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = new CarDTO(car.getId(), car.getIdquest(), car.getQuestion());
		return carDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Car toEntity(CarDTO carDTO) {
		Car car = new Car(carDTO.getId(), carDTO.getIdquest(), carDTO.getQuestion());
		return car;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<CarDTO> toDTOList(List<Car> carList) {
		//Crea una lista vuota.
		List<CarDTO> carDTOList = new ArrayList<CarDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Car car : carList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			carDTOList.add(toDTO(car));
		}
		return carDTOList;
	}

	
	
}
