package com.sunny.runnerz.run;

import java.time.LocalDateTime;
//creating using Record
public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  Integer miles,
                  Location location) {  }
