package sms.app

class CommodityController {

  	def smsService
	def add() {
		if (request.method == 'GET') {
			[commodity: new Commodity()]
		}
		else {
			def commodity = SmsService.createCommodity(params.commodity?.Name,
				params.commodity?.price, params.commodity?.quantity, params.commodity?.type)
			if (!commodity.hasErrors()) {
				redirect action: 'show', id: commodity.id
				return
			}

			[commodity: Commodity]
		}
	}

	def show() {
		def commodity= Commodity.get(params.id)
		if (Commodity) {
			[commodity: Commodity]
		}
		else {
			response.sendError 404
		}
	}

	def edit() {
		def commodity = Commodity.get(params.id)
		if (request.method == 'GET') {
			render view: 'add', model: [commodity: Commodity]
		}
		else {
			SmsService.updateCommodity(Commodity.get(params.id), params.commodity?.Name,
				params.commodity?.price, params.commodity?.quantity, params.commodity?.type)
			if (!commodity.hasErrors()) {
				redirect action: 'show', id: commodity.id
				return
			}

			render view: 'add', model: [commodity: Commodity]
		}
	}

	def find() {
		if (request.method == 'POST') {
			def commodity = Commodity.findAllByname(params.name)
			if (commodity) {
				if (commodity.size() > 1) {
					render view: 'selection', model: [commodity: Commodity]
				}
				else {
					redirect action: 'show', id: commodity[0].id
				}
			}
			else {
				[message: 'Commodity.not.found']
			}
		}
	}
}
