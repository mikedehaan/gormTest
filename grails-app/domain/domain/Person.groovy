package domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

/**
 * Created by mike on 2/26/2016.
 */
class Person {
    @Id
    ObjectId id;
    String name;
    String description;
    ObjectId scopeId
}
