package solid.humank.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import solid.humank.domains.Order;

@Data
public class OrderEstablishedEvent implements DomainEvent {

    private Order establishedOrder;

    public OrderEstablishedEvent(Order order) {
        this.establishedOrder = order;
    }

    @Override
    public String getEventContent() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(establishedOrder);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{\"error\":\"Data error\"}";
    }
}
