package com.example.matulohka.presentation.utils

import com.example.matulohka.data.model.GoodsModel

object GetGoods {
    fun getGoodsAs(goodsModel: GoodsModel, count: Int) : List<GoodsModel>{
        return List(count) { goodsModel }
    }
}