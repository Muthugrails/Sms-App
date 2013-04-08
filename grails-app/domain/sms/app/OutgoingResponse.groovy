package sms.app

class OutgoingResponse {
	static belongsTo = [sms:Sms]
	String message

    static constraints = {
		message (blank:false, nullable:false, size:1..160, matches:"[a-zA-Z1-9_-%#.,:]+")
    }
}
