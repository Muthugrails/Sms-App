package sms.app

class OutgoingResponse {
	static belongsTo = [sms:Sms]
	String message

    static constraints = {
    }
}
