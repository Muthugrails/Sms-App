package sms.app

class UserController {

    def smsService
	def add() {
		if (request.method == 'GET') {
			[user: new User()]
		}
		else {
			def user = SmsService.createUser(params.user?.name,
				params.user?.address, params.user?.age, params.user?.mobilenumber)
			if (!user.hasErrors()) {
				redirect action: 'show', id: user.id
				return
			}

			[user: User]
		}
	}

	def show() {
		def user = User.get(params.id)
		if (user) {
			[user: User]
		}
		else {
			response.sendError 404
		}
	}

	def edit() {
		def user = User.get(params.id)
		if (request.method == 'GET') {
			render view: 'add', model: [user: User]
		}
		else {
			SmsService.updateUser(User.get(params.id), params.user?.name,
				params.user?.address, params.user?.age, params.user?.mobilenumber)
			if (!user.hasErrors()) {
				redirect action: 'show', id: user.id
				return
			}

			render view: 'add', model: [user: User]
		}
	}

	def find() {
		if (request.method == 'POST') {
			def user = User.findAllBymobilenumber(params.mobilenumber)
			if (user) {
				if (user.size() > 1) {
					render view: 'selection', model: [user: user]
				}
				else {
					redirect action: 'show', id: user[0].id
				}
			}
			else {
				[message: 'User.not.found']
			}
		}
	}
}

