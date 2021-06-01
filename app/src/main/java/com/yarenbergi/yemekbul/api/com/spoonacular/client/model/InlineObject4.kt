/**
* spoonacular API
* The spoonacular Nutrition, Recipe, and Food API allows you to access over 380,000 recipes, thousands of ingredients, 80,000 food products, and 100,000 menu items. Our food ontology and semantic recipe search engine makes it possible to search for recipes using natural language queries, such as \"gluten free brownies without sugar\" or \"low fat vegan cupcakes.\" You can automatically calculate the nutritional information for any recipe, analyze recipe costs, visualize ingredient lists, find recipes for what's in your fridge, find recipes based on special diets, nutritional requirements, or favorite ingredients, classify recipes into types and cuisines, convert ingredient amounts, or even compute an entire meal plan. With our powerful API, you can create many kinds of food and especially nutrition apps.  Special diets/dietary requirements currently available include: vegan, vegetarian, pescetarian, gluten free, grain free, dairy free, high protein, whole 30, low sodium, low carb, Paleo, ketogenic, FODMAP, and Primal.
*
* The version of the OpenAPI document: 1.0
* Contact: david@spoonacular.com
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.yarenbergi.yemekbul.api.com.spoonacular.client.model


import com.squareup.moshi.Json
/**
 * 
 * @param title The title of the recipe.
 * @param image The binary image of the recipe as jpg.
 * @param ingredients The ingredient list of the recipe, one ingredient per line (separate lines with \\n).
 * @param instructions The instructions to make the recipe. One step per line (separate lines with \\n).
 * @param readyInMinutes The number of minutes it takes to get the recipe on the table.
 * @param servings The number of servings the recipe makes.
 * @param mask The mask to put over the recipe image (\"ellipseMask\", \"diamondMask\", \"starMask\", \"heartMask\", \"potMask\", \"fishMask\").
 * @param backgroundImage The background image (\"none\",\"background1\", or \"background2\").
 * @param author The author of the recipe.
 * @param backgroundColor The background color for the recipe card as a hex-string.
 * @param fontColor The font color for the recipe card as a hex-string.
 * @param source The source of the recipe.
 */
data class InlineObject4 (
    /* The title of the recipe. */
    @Json(name = "title")
    val title: kotlin.String,
    /* The binary image of the recipe as jpg. */
    @Json(name = "image")
    val image: java.io.File,
    /* The ingredient list of the recipe, one ingredient per line (separate lines with \\n). */
    @Json(name = "ingredients")
    val ingredients: kotlin.String,
    /* The instructions to make the recipe. One step per line (separate lines with \\n). */
    @Json(name = "instructions")
    val instructions: kotlin.String,
    /* The number of minutes it takes to get the recipe on the table. */
    @Json(name = "readyInMinutes")
    val readyInMinutes: java.math.BigDecimal,
    /* The number of servings the recipe makes. */
    @Json(name = "servings")
    val servings: java.math.BigDecimal,
    /* The mask to put over the recipe image (\"ellipseMask\", \"diamondMask\", \"starMask\", \"heartMask\", \"potMask\", \"fishMask\"). */
    @Json(name = "mask")
    val mask: kotlin.String,
    /* The background image (\"none\",\"background1\", or \"background2\"). */
    @Json(name = "backgroundImage")
    val backgroundImage: kotlin.String,
    /* The author of the recipe. */
    @Json(name = "author")
    val author: kotlin.String? = null,
    /* The background color for the recipe card as a hex-string. */
    @Json(name = "backgroundColor")
    val backgroundColor: kotlin.String? = null,
    /* The font color for the recipe card as a hex-string. */
    @Json(name = "fontColor")
    val fontColor: kotlin.String? = null,
    /* The source of the recipe. */
    @Json(name = "source")
    val source: kotlin.String? = null
) {

}

