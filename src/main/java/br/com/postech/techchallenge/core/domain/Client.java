package br.com.postech.techchallenge.core.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Client {
  private String cpf;
  private String name;
  private String email;
  private LocalDate dateOfBirth;
}
