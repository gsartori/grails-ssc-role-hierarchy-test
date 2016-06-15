import test.*

class BootStrap {

    def init = { servletContext ->

        if (!RoleHierarchyEntry.count()) {
            new RoleHierarchyEntry(entry: 'ROLE_ADMIN > ROLE_ONE').save()
            new RoleHierarchyEntry(entry: 'ROLE_ADMIN > ROLE_TWO').save()
        }


		def adminUser = new User(
			username: 'admin',
			password: 'admin',
			).save()
	    def adminRole = new Role(authority: 'ROLE_ADMIN').save()
		UserRole.create adminUser, adminRole

		def oneUser = new User(
			username: 'one',
			password: 'one',
			).save()
	    def oneRole = new Role(authority: 'ROLE_ONE').save()
		UserRole.create oneUser, oneRole

		def twoUser = new User(
			username: 'two',
			password: 'two',
			).save()
	    def twoRole = new Role(authority: 'ROLE_TWO').save()
		UserRole.create twoUser, twoRole

		UserRole.withSession {
			it.flush()
			it.clear()
		}


        println User.findAll()
        println Role.findAll()
        println UserRole.findAll()
        println RoleHierarchyEntry.findAll()

    }

    def destroy = {
    }
}
