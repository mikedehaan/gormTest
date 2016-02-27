package gormtest

import com.mongodb.client.MongoCollection
import domain.Person
import org.bson.types.ObjectId

class PersonController {

    def index() {
        Person person = new Person();
        person.name = "Mike" + System.currentTimeMillis();
        person.description = System.currentTimeMillis();
        person.scopeId = new ObjectId();
        person.save(failOnError: true, flush: true);

        List<Person> personList = Person.findAll();

        // Find one with a scopeId that has been set
        Person scopePerson = personList.find {
            it.scopeId != null;
        }

        println(scopePerson.scopeId);

        Map<String, Boolean> resultMap = [:];

        // Try to find that person again by scope id
        Person scopePerson2 = Person.findByScopeId(scopePerson.scopeId);
        println("Found via GORM by ObjectId" + scopePerson2?.scopeId);
        resultMap.put("gormObjectId", (scopePerson2?.scopeId != null));

        // Directly use the driver to find the row as a String
        MongoCollection collection = Person.collection;
        Person scopePerson3 = collection.findOne([scopeId : scopePerson.scopeId.toString()]) as Person;
        println("Found via MongoCollection by String: " + scopePerson3?.scopeId);
        resultMap.put("collectionString", (scopePerson3?.scopeId != null));

        // Directly use the driver to find the row as an ObjectId
        Person scopePerson4 = collection.findOne([scopeId : scopePerson.scopeId]) as Person;
        println("Found via MongoCollection by ObjectId: " + scopePerson4?.scopeId);
        resultMap.put("collectionObjectId", (scopePerson4?.scopeId != null));

        ['personList' : personList, 'resultMap' : resultMap];
    }
}
