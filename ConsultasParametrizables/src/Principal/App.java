package Principal;

import DAO.DAO;

public class App {

	public static void main(String[] args) {
		DAO miPrimerDao= new DAO();
		miPrimerDao.eliminar(12345678);

	}

}
