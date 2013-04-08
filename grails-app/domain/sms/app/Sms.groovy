package sms.app

class Sms {
	Commodity commodity
	Register register
	OutgoingResponse outgoingresponse
	static hasMany = [user:User]
	String mobilenumber
	Date timestamp
	String type

    static constraints = {
		mobilenumber(nullable:false, size:10, matches:"[0-9]+")
		timestamp(nullable:false, size:1.value.MIN_VALUE, matches:"[0-9]+")
		type (blank:false, nullable:false, size:1..20, matches:"[a-zA-Z]+")
		
    }
}
