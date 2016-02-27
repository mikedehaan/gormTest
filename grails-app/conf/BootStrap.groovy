import domain.Person

class BootStrap {

    def init = { servletContext ->
        // Delete all person objects to start fresh
        Person.deleteAll(Person.findAll());
    }
    def destroy = {
    }
}
