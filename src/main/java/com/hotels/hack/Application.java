package com.hotels.hack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  // @Autowired
  // private ExperimentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // @Override
  // public void run(String... arg0) throws Exception {
  // // repository.deleteAll();
  //
  // // save a couple of customers
  // repository.save(new ExperimentStatus("Ambrish", "Bhargava", ExperimentStatus.Status.CLOSE));
  // repository.save(new ExperimentStatus("Bob", "Smith", ExperimentStatus.Status.LIVE));
  //
  // // fetch all customers
  // System.out.println("-------------------------------");
  // for (ExperimentStatus status : repository.findAll()) {
  // System.out.println(status);
  // }
  // System.out.println();
  //
  // // fetch an individual customer
  // System.out.println("Customer found with findByFirstName('Alice'):");
  // System.out.println("--------------------------------");
  // System.out.println(repository.findByExperimentCode("Ambrish"));
  //
  // }

}
