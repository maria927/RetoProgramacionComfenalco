package com.reto.dao;

import java.util.UUID;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.reto.back.Process;
import com.reto.vo.VOparametros;

public class CalculoDao {

	static Session sessionObj;

	public void saveCalculoParametro(VOparametros parametros) {

		try {
			Calculo calculo = new Calculo();
			Process proccess = new Process();
		
			calculo.alto = parametros.alto;
			calculo.data = parametros.data;
			calculo.ancho = parametros.ancho;
			calculo.operacion = parametros.operationiD;
			calculo.result = (parametros.charReturn == null) ? proccess.ListToString(parametros.stringReturn): proccess.MatrixToString(parametros.charReturn);

			

			sessionObj = SessionF.buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			sessionObj.save(calculo);

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			throw sqlException;
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

	}
	


}
