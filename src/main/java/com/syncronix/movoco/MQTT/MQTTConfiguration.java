package com.syncronix.movoco.MQTT;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQTTConfiguration {

    @Value("${exchange.name}")
    private String movocoName;

    @Value("${exchange.queue.voltSensor.name}")
    private String voltSensor;

    @Value("${exchange.queue.ampSensor.name}")
    private String ampSensor;

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());

        return rabbitTemplate;

    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue ampSensorqueue() {

        return new Queue(ampSensor);
    }

    @Bean
    public Queue voltSensorqueue(){

        return new Queue(voltSensor);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(movocoName);
    }

    @Bean
    public Binding bindingAmpSensorQueue(){

        return BindingBuilder.bind(ampSensorqueue()).to(exchange()).with("ampSensorData");

    }

    @Bean
    public Binding bindingVoltSensorQueue(){

        return BindingBuilder.bind(voltSensorqueue()).to(exchange()).with("voltSensorData");
    }

}
