package com.ti.mpreventiva;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication; // Importação necessária
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importação necessária

@SpringBootApplication
public class MpreventivaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpreventivaApplication.class, args);

        // Testa o driver JDBC
		try (var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basetestes", "root", "root123")) {
			System.out.println("Conexão com o banco de dados bem-sucedida!");
		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
    }
}