package main.program.Models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Peixe.class)
public abstract class Peixe_ extends main.program.Models.Entidade_ {

	public static volatile SingularAttribute<Peixe, Double> MaxTemp;
	public static volatile SingularAttribute<Peixe, Double> PrecoUnitario;
	public static volatile SingularAttribute<Peixe, Double> MinTemp;
	public static volatile SingularAttribute<Peixe, Double> MinpH;
	public static volatile SingularAttribute<Peixe, Double> MaxpH;
	public static volatile SingularAttribute<Peixe, String> Especie;

	public static final String MAX_TEMP = "MaxTemp";
	public static final String PRECO_UNITARIO = "PrecoUnitario";
	public static final String MIN_TEMP = "MinTemp";
	public static final String MINP_H = "MinpH";
	public static final String MAXP_H = "MaxpH";
	public static final String ESPECIE = "Especie";

}

