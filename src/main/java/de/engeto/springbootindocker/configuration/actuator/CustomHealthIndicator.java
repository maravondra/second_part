package de.engeto.springbootindocker.configuration.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);
        if(i < 5){
            return Health.up().withDetail("db1", this.checkDb1()).build();
        }else if(i < 7) {
            return Health.down().withDetail("error", "Neco se stalo").build();
        }else {
            return Health.unknown().withDetail("unclear", "it is not clear").build();
        }
    }

    private boolean checkDb1(){
        return true;
    }
}
