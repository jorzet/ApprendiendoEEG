package com.jorzet.apprendiendoeeg.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


/**
 * Created by Jorge Zepeda Tinoco on 25/02/18.
 * jorzet.94@gmail.com
 */
class Pager(context : Context, fm : FragmentManager?, tabCount : Int) : FragmentStatePagerAdapter(fm) {

    private val mContext : Context? = context
    private val mTabCount : Int = tabCount

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return null
            1 -> return null
            2 -> return null
            else -> return null
        }
    }

    override fun getCount(): Int {
        return mTabCount
    }
}