package com.techwireme.athath.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dotinfiny.banglesystem.R

inline fun FragmentManager.transaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.add(fragment: Fragment, container: Int) {
    supportFragmentManager.transaction {
        setCustomAnimations(R.anim.enter_from_right, R.anim.bottom_down, R.anim.bottom_down, R.anim.bottom_down)
        add(container, fragment)
    }
}

fun AppCompatActivity.addWithBackStack(fragment: Fragment, container: Int) {
    supportFragmentManager.transaction {
        setCustomAnimations(R.anim.enter_from_right, R.anim.bottom_down, R.anim.bottom_down, R.anim.bottom_down)
        addToBackStack(fragment.javaClass.name)
        add(container, fragment)
    }
}

fun AppCompatActivity.addWithBackStackWithCondition(fragment: Fragment, container: Int) {
    if(!fragment.isAdded){
        supportFragmentManager.transaction {
            setCustomAnimations(R.anim.enter_from_right, R.anim.bottom_down, R.anim.bottom_down, R.anim.bottom_down)
            addToBackStack(fragment.javaClass.name)
            add(container, fragment)
        }
    }
}


fun AppCompatActivity.addWithArguments(fragment: Fragment, container: Int, bundle: Bundle) {
    supportFragmentManager.transaction {
        fragment.arguments = bundle
        setCustomAnimations(R.anim.enter_from_right, R.anim.bottom_down, R.anim.bottom_down, R.anim.bottom_down)
        addToBackStack(fragment.javaClass.name)
        add(container, fragment)
    }
}

fun AppCompatActivity.addWithBottomAnimation(fragment: Fragment, container: Int, bundle: Bundle) {
    supportFragmentManager.transaction {
        fragment.arguments = bundle
        setCustomAnimations(R.anim.bottom_up, R.anim.bottom_down, R.anim.bottom_down, R.anim.bottom_down)
        addToBackStack(fragment.javaClass.name)
        add(container, fragment)
    }
}

fun AppCompatActivity.addWithBottomAnimationMore(fragment: Fragment, container: Int, bundle: Bundle) {
    supportFragmentManager.transaction {
        fragment.arguments = bundle
        setCustomAnimations(R.anim.bottom_up, R.anim.bottom_down_slow, R.anim.bottom_up, R.anim.bottom_down_slow)
        addToBackStack(fragment.javaClass.name)
        add(container, fragment)
    }
}

fun AppCompatActivity.replace(fragment: Fragment, container: Int) {
    supportFragmentManager.transaction { replace(container, fragment) }
}
