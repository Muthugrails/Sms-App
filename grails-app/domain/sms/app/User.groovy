package sms.app

class User {
	static belongsTo = [sms:Sms]
	String name
	String address
	int mobilenumber
	int age
    static constraints = {
		name (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z_]+")
		address (blank:false, nullable:false, size:10..50, matches:"[a-zA-Z1-9_%#/:,.]+")
		mobilenumber(nullable:false, size:10, matches:"[0-9]+")
		age(nullable:false, size:18..100, matches:"[0-9]+")
    }
}
