package com.example.intellifishbackend.MQTT;


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
    private String intelliFishName;

    @Value("${exchange.queue.phSensor.name}")
    private String phSensor;

    @Value("${exchange.queue.waterTemperatureSensor.name}")
    private String waterTemperatureSensor;

    @Value("${exchange.queue.waterFlowSensor.name}")
    private String waterFlowSensor;

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
    public Queue phSensorqueue() {

        return new Queue(phSensor);
    }

    @Bean
    public Queue waterTemperaturequeue(){

        return new Queue(waterTemperatureSensor);
    }

    @Bean
    public Queue waterFlowqueue(){

        return new Queue(waterFlowSensor);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(intelliFishName);
    }

    @Bean
    public Binding bindingPhSensorQueue(){

        return BindingBuilder.bind(phSensorqueue()).to(exchange()).with("phSensorData");

    }

    @Bean
    public Binding bindingWaterTemperatureQueue(){

        return BindingBuilder.bind(waterTemperaturequeue()).to(exchange()).with("waterTemperatureSensorData");
    }

    @Bean
    public Binding bindingWaterFlowQueue(){

        return BindingBuilder.bind(waterFlowqueue()).to(exchange()).with("waterFlowSensorData");
    }



}
