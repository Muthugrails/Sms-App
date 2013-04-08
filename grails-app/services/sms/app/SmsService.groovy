package sms.app

class SmsService {

	//SMScontroller details
	
    Sms CreateSms(int mobilenumber, Date timestamp, String type) {
		def Sms = new Sms( Mobilenumber: mobilenumber, Timestamp: timestamp, Type: type)
		Sms.save()
		Sms

    }
	
	//Usercontroller details
	
	User CreateUser(String name, String address, int age, int mobilenumber ) {
	  def User = new User( Name: name, Address: address, Age: age, Mobilenumber: mobilenumber )
	  User.save()
	  User
	}
	
	void updateUser(User user, String name, String address,int age, int mobilenumber) {
		User.name = name
		User.address = address
		User.age = age
		User.mobilenumber = mobilenumber
		User.save()
	}
	
	//commoditycontroller
	
	Commodity CreateCommodity(String name, int price, int quantity, String type) {
	    
		}
	}
	
