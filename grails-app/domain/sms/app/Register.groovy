package sms.app

class Register {
	static belongsTo = [sms:Sms]
	String message

    static constraints = {
		
    }
}
