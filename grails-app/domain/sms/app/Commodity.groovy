package sms.app

class Commodity {
	static belongsTo = [sms:Sms]
	String name
	String type
	Integer price
	int quantity

    static constraints = {
		name (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z]+")
		type (blank:false, nullable:false, size:1..20, matches:"[a-zA-Z]+")
		price( nullable:false, size:1.value.MAX_VALUE, matches:"[0-9]+")
		quantity(nullable:false, size:1.value.MAX_VALUE, matches:"[0-9]+")
    }
}
