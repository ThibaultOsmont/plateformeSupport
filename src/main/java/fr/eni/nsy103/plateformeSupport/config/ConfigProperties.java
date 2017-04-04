package fr.eni.nsy103.plateformeSupport.config;

/**
 * Fichier de properties pour la configuration
 * 
 * @author tosmont2016
 *
 */
public class ConfigProperties {
	protected final static String DATABASE_DRIVER = "";
	protected final static String DATABASE_URL = "http://10.15.200.4:3306/";
	protected final static String DATABASE_USER = "root";
	protected final static String DATABASE_PWD = "";
	
	protected final static String[] packagesToScan = {
		"fr.eni.nsy103.plateformeSupport.dao"
	};
	
	protected final static String SQL_DIALECT = "org.hibernate.dialect.SQLServer2012Dialect";
	protected final static String HIBERNATE_SHOW_SQL = "false";
}
