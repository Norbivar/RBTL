package hu.adatb.rbtl.view;

/**
 * String constants used in the application. 
 * Changing them here is easier if needed.
 * @author Attila Uhrin
 *
 */
public class Labels {

	//Main screen
	public static final String MAIN_TITLE = "Read Between The Line Bookshop - Desktop Application";
	public static final String MAIN_WELCOME = "Welcome";
	
	//Menubar
	public static final String FILE_MENU = "File";
	public static final String FILE_MENUITEM_HOME = "Home";
	public static final String FILE_MENUITEM_EXIT = "Exit";

	public static final String USER_MENU = "User settings";
	public static final String USER_MENUITEM_REGISTER = "Sign up";
	public static final String USER_MENUITEM_LOGIN = "Sign in";
	public static final String USER_MENUITEM_SIGNOUT = "Sign out";
	public static final String USER_MENUITEM_EDITPROFILE = "Edit profile";
	
	public static final String SHOP_MENU = "Shops";
	public static final String SHOP_MENUITEM_BROWSE = "Browse a shop's collection";
	public static final String SHOP_MENUITEMS_SEARCH = "Search a specific book in a shop's collection";
	
	public static final String CART_MENU = "Cart";
	public static final String SHOW_CART_MENUITEM = "Show cart";
	public static final String CART_CHECKOUT_MENUITEM = "Checkout";
	
	public static final String PRODUCTS_MENU = "Products";
	public static final String PRODUCTS_MENUITEM_SEARCH = "Search products";
	public static final String PRODUCTS_MENUITEM_TOPLIST = "Product toplists";
	public static final String PRODUCTS_MENUITEM_CHEAP = "Cheap products";
	public static final String PRODUCTS_POPULAR_BOOKS = "Popular books";
	
	//Sign up
	public static final String USER_SIGNUP_TITLE = "Sign up";
	public static final String USER_SIGNUP_NAME = "Full name: (max 64 characters)";
	public static final String USER_SIGNUP_EMAIL = "E-mail: (max 64 characters)";
	public static final String USER_SIGNUP_PASSWORD = "Password: (max 30 characters)";
	public static final String USER_SIGNUP_OKBUTTON = "OK";
	public static final String USER_SIGNUP_CANCELBUTTON = "Cancel";
	public static final String USER_SIGNUP_SUCCESSFUL = "Registration succesful";
	public static final String USER_SIGNUP_FAILED = "Registration failed";
	
	//Log in
	public static final String USER_LOGIN_TITLE = "Log in";
	public static final String USER_LOGIN_NAME = "Full name:";
	public static final String USER_LOGIN_EMAIL = "E-mail: (max 64 characters)";
	public static final String USER_LOGIN_PASSWORD = "Password: (max 30 characters)";
	public static final String USER_LOGIN_OKBUTTON = "OK";
	public static final String USER_LOGIN_CANCELBUTTON = "Cancel";
	public static final String USER_LOGIN_SUCCESSFUL = "Logged in successfully";
	public static final String USER_LOGIN_FAILED = "Failed to log in";
	public static final String USER_ALREADY_LOGGED_IN = "You have already logged in!";
	
	//Sign out
	public static final String USER_SIGNOUT_TITLE = "Sign out";
	public static final String USER_SIGNOUT_SUCCESSFUL = "You signed out successfully.";
	public static final String USER_SIGNOUT_ERROR = "There was an error while trying to log out. Please try again later.";
	
	//Search products
	public static final String SEARCH_PRODUCTS_PANE_TITLE = "Search products";
	public static final String SEARCH_PRODUCTS_CATEGORY = "Product category:";
	public static final String SEARCH_PRODUCTS_TITLE = "Title:";
	public static final String SEARCH_PRODUCTS_ISBN = "ISBN number: (13 digits)";
	public static final String SEARCH_PRODUCTS_PAGES = "Number of pages:";
	public static final String SEARCH_PRODUCTS_BINDING = "Type of binding:";
	public static final String SEARCH_PRODUCTS_SIZE = "Size of book:";
	public static final String SEARCH_PRODUCTS_PRICE = "Price: ($)";
	public static final String SEARCH_PDORUCTS_PUBLISHER = "Publisher:";
	public static final String SEARCH_PRODUCTS_DATE_OF_PUBLISHING = "Year of publishing:";
	public static final String SEARCH_PRODUCTS_OKBUTTON = "OK";
	public static final String SEARCH_PRODUCTS_CANCELBUTTON = "Cancel";
	
	//PRODUCT SEARCH RESULT
	public static final String PRODUCT_RESULT_PANE_TITLE = "Result:";
	public static final String PRODUCT_RESULT_TITLE = "Title: ";
	public static final String PRODUCT_RESULT_AUTHOR = "Author: ";
	public static final String PRODUCT_RESULT_ISBN = "ISBN number: ";
	public static final String PRODUCT_RESULT_PUBLISHER = "Publisher: ";
	public static final String PRODUCT_RESULT_PRICE = "Price: ($) ";
	public static final String PRODUCT_DETAILS_BUTTON = "Details";
	
	//PRODUCT DETAILS
	public static final String PRODUCT_ISBN = "ISBN:";
	public static final String PRODUCT_TITLE = "Title:";
	public static final String PRODUCT_OLDALSZAM = "Number of pages:";
	public static final String PRODUCT_KOTES = "Binding:";
	public static final String PRODUCT_MERET = "Size:";
	public static final String PRODUCT_AR = "Price: ($)";
	public static final String PRODUCT_KIADO = "Publisher:";
	public static final String PRODUCT_KIADASEVE = "Year of publishing:";
	public static final String PRODUCT_SZERZO = "Author:";
	public static final String PRODUCT_GENRE = "Genre(s):";
	
	//Edit Profile
	public static final String EDIT_PROFILE_PANE_TITLE ="Edit Profile: ";
	public static final String EDIT_PROFILE_USER_NAME ="User Name: ";
	public static final String EDIT_PROFILE_EMAIL="Email: ";
	public static final String EDIT_PROFILE_CURRENT_PASSWORD="Current Password: ";
	public static final String EDIT_PROFILE_NEW_PASSWORD1="New Password:";
	public static final String EDIT_PROFILE_NEW_PASSWORD2="New Password Again: ";
	public static final String EDIT_PROFILE_OKBUTTON = "Change";
	
	//User Edit Profile Dialog
	public static final String USER_EDIT_DIALOG_OKBUTTON ="OK";
	public static final String USER_EDIT_DIALOG_CANCELBUTTON ="Cancel";
	public static final String USER_EDIT_DIALOG_TITLE = "Enter Your Current Password";
	public static final String USER_EDIT_ENTER_CURRENT_PASSWORD ="You must enter your current password";

	public static final String EDIT_PROFILE_CANCELBUTTON ="Cancel";

	public static final String EDIT_PROFILE_PASSWORD_DIALOG_TITLE ="Invalid Passwords";
	public static final String EDIT_PROFILE_PASSWORD_DIALOG_PASSWORD ="Enter the same passwords for changing it.";
	public static final String EDIT_PROFILE_PASSWORD_DIALOG_OKBUTTON ="OK";
	public static final String EDIT_PROFILE_PASSWORD_DIALOG_CANCELBUTTON ="Cancel";
	
	//Top List Screen
	public static final String TOP_LIST_TITLE ="Top Lists";
	public static final String TOP_LIST_WEEKLY ="Weekly Top Books";
	public static final String TOP_LIST_MONTHLY ="Monthly Top Books";
	public static final String TOP_LIST_BY_GENRE ="Top Books By Genre";
	public static final String TOP_LIST_BACK_BUTTON ="BACK";
	
	//SELECT SHOP WHERE YOU CAN FIND A SPECIFIC BOOK
	public static final String SHOPSEARCH_SELECTBOOK = "Select";
	
	
	//BROWSE SHOPS
	public static final String SHOP_SELECTSHOP = "Select shop: ";
	public static final String SHOP_AMOUNT = "Amount: ";
	
	//BOOKS, CATEGORY BY PRICE
	public static final String CHEAPBOOK_10 = "Less than 10 $";
	public static final String CHEAPBOOK_20 = "10-20 $";
	public static final String CHEAPBOOK_30 = "20-30 $";
	public static final String CHEAPBOOK_40 = "30-40 $";
	public static final String CHEAPBOOK_50 = "40-50$ ";
	public static final String CHEAPBOOK_MORE = "More than 50 $";
	
	//ADD TO CART DIALOG
	public static final String ADD_TO_CART_TITLE = "Add to your cart";

	public static final String CART_ID_AND_TITLE = "Code and Title";
	public static final String CART_AMOUNT_OF_ITEM = "Amount";
	public static final String CART_DELETE = "Delete From Cart";
	
	public static final String CART_CHECKOUT_TOTAL = "Total price:";
}
