package com.example.dhiwisepracticaltask.model

import com.google.gson.annotations.SerializedName

data class FigmaFileResponse(

	@field:SerializedName("components")
	val components: Components? = null,

	@field:SerializedName("schemaVersion")
	val schemaVersion: Int? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("document")
	val document: Document? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("styles")
	val styles: Styles? = null,

	@field:SerializedName("componentSets")
	val componentSets: ComponentSets? = null,

	@field:SerializedName("lastModified")
	val lastModified: String? = null,

	@field:SerializedName("linkAccess")
	val linkAccess: String? = null,

	@field:SerializedName("editorType")
	val editorType: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
)

data class ComponentProperties(

	@field:SerializedName("Property 1")
	val property1: Property1? = null
)

data class JsonMember7(

	@field:SerializedName("letterSpacing")
	val letterSpacing: Any? = null,

	@field:SerializedName("fills")
	val fills: List<FillsItem?>? = null
)

data class JsonMember10(

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null
)

data class Styles(

	@field:SerializedName("12:2468")
	val jsonMember122468: JsonMember122468? = null,

	@field:SerializedName("264:139")
	val jsonMember264139: JsonMember264139? = null,

	@field:SerializedName("13:82")
	val jsonMember1382: JsonMember1382? = null,

	@field:SerializedName("4:94")
	val jsonMember494: JsonMember494? = null,

	@field:SerializedName("264:201")
	val jsonMember264201: JsonMember264201? = null,

	@field:SerializedName("264:134")
	val jsonMember264134: JsonMember264134? = null,

	@field:SerializedName("4:32")
	val jsonMember432: JsonMember432? = null,

	@field:SerializedName("13:176")
	val jsonMember13176: JsonMember13176? = null,

	@field:SerializedName("fill")
	val fill: String? = null,

	@field:SerializedName("fills")
	val fills: String? = null,

	@field:SerializedName("stroke")
	val stroke: String? = null,

	@field:SerializedName("effect")
	val effect: String? = null
)

data class GradientHandlePositionsItem(

	@field:SerializedName("x")
	val x: Any? = null,

	@field:SerializedName("y")
	val y: Any? = null
)

data class JsonMember13176(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember70(

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("lineHeightPx")
	val lineHeightPx: Any? = null,

	@field:SerializedName("lineHeightPercentFontSize")
	val lineHeightPercentFontSize: Any? = null,

	@field:SerializedName("letterSpacing")
	val letterSpacing: Any? = null,

	@field:SerializedName("lineHeightUnit")
	val lineHeightUnit: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontSize")
	val fontSize: Any? = null,

	@field:SerializedName("lineHeightPercent")
	val lineHeightPercent: Any? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null
)

data class JsonMember13136(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember8(

	@field:SerializedName("fills")
	val fills: List<FillsItem?>? = null,

	@field:SerializedName("inheritFillStyleId")
	val inheritFillStyleId: String? = null,

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null
)

data class FillOverrideTable(

	@field:SerializedName("1")
	val jsonMember1: JsonMember1? = null,

	@field:SerializedName("2")
	val jsonMember2: Any? = null
)

data class GradientStopsItem(

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("position")
	val position: Any? = null
)

data class FillsItem(

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("blendMode")
	val blendMode: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("visible")
	val visible: Boolean? = null,

	@field:SerializedName("scaleMode")
	val scaleMode: String? = null,

	@field:SerializedName("imageRef")
	val imageRef: String? = null,

	@field:SerializedName("gradientStops")
	val gradientStops: List<GradientStopsItem?>? = null,

	@field:SerializedName("gradientHandlePositions")
	val gradientHandlePositions: List<GradientHandlePositionsItem?>? = null,

	@field:SerializedName("imageTransform")
	val imageTransform: List<List<Any?>?>? = null
)

data class Style(

	@field:SerializedName("textAutoResize")
	val textAutoResize: String? = null,

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("textAlignVertical")
	val textAlignVertical: String? = null,

	@field:SerializedName("lineHeightPx")
	val lineHeightPx: Any? = null,

	@field:SerializedName("textAlignHorizontal")
	val textAlignHorizontal: String? = null,

	@field:SerializedName("letterSpacing")
	val letterSpacing: Any? = null,

	@field:SerializedName("lineHeightUnit")
	val lineHeightUnit: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontSize")
	val fontSize: Any? = null,

	@field:SerializedName("lineHeightPercent")
	val lineHeightPercent: Any? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null,

	@field:SerializedName("italic")
	val italic: Boolean? = null,

	@field:SerializedName("lineHeightPercentFontSize")
	val lineHeightPercentFontSize: Any? = null
)

data class ChildrenItem(

	@field:SerializedName("backgroundColor")
	val backgroundColor: BackgroundColor? = null,

	@field:SerializedName("flowStartingPoints")
	val flowStartingPoints: List<Any?>? = null,

	@field:SerializedName("children")
	val children: List<ChildrenItem?>? = null,

	@field:SerializedName("prototypeStartNodeID")
	val prototypeStartNodeID: Any? = null,

	@field:SerializedName("exportSettings")
	val exportSettings: List<Any?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("scrollBehavior")
	val scrollBehavior: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("prototypeDevice")
	val prototypeDevice: PrototypeDevice? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("strokes")
	val strokes: List<Any?>? = null,

	@field:SerializedName("clipsContent")
	val clipsContent: Boolean? = null,

	@field:SerializedName("strokeWeight")
	val strokeWeight: Any? = null,

	@field:SerializedName("constraints")
	val constraints: Constraints? = null,

	@field:SerializedName("effects")
	val effects: List<EffectsItem?>? = null,

	@field:SerializedName("blendMode")
	val blendMode: String? = null,

	@field:SerializedName("background")
	val background: List<BackgroundItem?>? = null,

	@field:SerializedName("strokeAlign")
	val strokeAlign: String? = null,

	@field:SerializedName("absoluteBoundingBox")
	val absoluteBoundingBox: AbsoluteBoundingBox? = null,

	@field:SerializedName("styles")
	val styles: Styles? = null,

	@field:SerializedName("absoluteRenderBounds")
	val absoluteRenderBounds: AbsoluteRenderBounds? = null,

	@field:SerializedName("fills")
	val fills: List<FillsItem?>? = null,

	@field:SerializedName("visible")
	val visible: Boolean? = null,

	@field:SerializedName("layoutGrids")
	val layoutGrids: List<LayoutGridsItem?>? = null,

	@field:SerializedName("cornerSmoothing")
	val cornerSmoothing: Any? = null,

	@field:SerializedName("rectangleCornerRadii")
	val rectangleCornerRadii: List<Any?>? = null,

	@field:SerializedName("booleanOperation")
	val booleanOperation: String? = null,

	@field:SerializedName("isMaskOutline")
	val isMaskOutline: Boolean? = null,

	@field:SerializedName("maskType")
	val maskType: String? = null,

	@field:SerializedName("isMask")
	val isMask: Boolean? = null,

	@field:SerializedName("strokeJoin")
	val strokeJoin: String? = null,

	@field:SerializedName("strokeCap")
	val strokeCap: String? = null,

	@field:SerializedName("layoutVersion")
	val layoutVersion: Int? = null,

	@field:SerializedName("lineIndentations")
	val lineIndentations: List<Int?>? = null,

	@field:SerializedName("characters")
	val characters: String? = null,

	@field:SerializedName("characterStyleOverrides")
	val characterStyleOverrides: List<Any?>? = null,

	@field:SerializedName("style")
	val style: Style? = null,

	@field:SerializedName("lineTypes")
	val lineTypes: List<String?>? = null,

	@field:SerializedName("styleOverrideTable")
	val styleOverrideTable: StyleOverrideTable? = null,

	@field:SerializedName("preserveRatio")
	val preserveRatio: Boolean? = null,

	@field:SerializedName("arcData")
	val arcData: ArcData? = null,

	@field:SerializedName("componentId")
	val componentId: String? = null,

	@field:SerializedName("overrides")
	val overrides: List<OverridesItem?>? = null,

	@field:SerializedName("fillOverrideTable")
	val fillOverrideTable: FillOverrideTable? = null,

	@field:SerializedName("cornerRadius")
	val cornerRadius: Any? = null,

	@field:SerializedName("opacity")
	val opacity: Any? = null,

	@field:SerializedName("rotation")
	val rotation: Any? = null,

	@field:SerializedName("strokeMiterAngle")
	val strokeMiterAngle: Any? = null,

	@field:SerializedName("layoutWrap")
	val layoutWrap: String? = null,

	@field:SerializedName("itemSpacing")
	val itemSpacing: Any? = null,

	@field:SerializedName("layoutSizingVertical")
	val layoutSizingVertical: String? = null,

	@field:SerializedName("layoutSizingHorizontal")
	val layoutSizingHorizontal: String? = null,

	@field:SerializedName("layoutMode")
	val layoutMode: String? = null,

	@field:SerializedName("primaryAxisSizingMode")
	val primaryAxisSizingMode: String? = null,

	@field:SerializedName("layoutAlign")
	val layoutAlign: String? = null,

	@field:SerializedName("paddingRight")
	val paddingRight: Any? = null,

	@field:SerializedName("layoutGrow")
	val layoutGrow: Any? = null,

	@field:SerializedName("paddingBottom")
	val paddingBottom: Any? = null,

	@field:SerializedName("paddingTop")
	val paddingTop: Any? = null,

	@field:SerializedName("paddingLeft")
	val paddingLeft: Any? = null,

	@field:SerializedName("counterAxisSizingMode")
	val counterAxisSizingMode: String? = null,

	@field:SerializedName("primaryAxisAlignItems")
	val primaryAxisAlignItems: String? = null,

	@field:SerializedName("counterAxisAlignItems")
	val counterAxisAlignItems: String? = null,

	@field:SerializedName("isFixed")
	val isFixed: Boolean? = null,

	@field:SerializedName("componentProperties")
	val componentProperties: ComponentProperties? = null,

	@field:SerializedName("locked")
	val locked: Boolean? = null
)

data class EffectsItem(

	@field:SerializedName("visible")
	val visible: Boolean? = null,

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("offset")
	val offset: Offset? = null,

	@field:SerializedName("blendMode")
	val blendMode: String? = null,

	@field:SerializedName("showShadowBehindNode")
	val showShadowBehindNode: Boolean? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("radius")
	val radius: Any? = null,

	@field:SerializedName("spread")
	val spread: Any? = null
)

data class PrototypeDevice(

	@field:SerializedName("rotation")
	val rotation: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class JsonMember264139(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class ExportSettingsItem(

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("constraint")
	val constraint: Constraint? = null,

	@field:SerializedName("suffix")
	val suffix: String? = null
)

data class BackgroundItem(

	@field:SerializedName("visible")
	val visible: Boolean? = null,

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("blendMode")
	val blendMode: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("gradientStops")
	val gradientStops: List<GradientStopsItem?>? = null,

	@field:SerializedName("gradientHandlePositions")
	val gradientHandlePositions: List<GradientHandlePositionsItem?>? = null
)

data class Constraints(

	@field:SerializedName("horizontal")
	val horizontal: String? = null,

	@field:SerializedName("vertical")
	val vertical: String? = null
)

data class JsonMember432(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember1586296(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember9(

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null,

	@field:SerializedName("inheritFillStyleId")
	val inheritFillStyleId: String? = null,

	@field:SerializedName("fills")
	val fills: List<FillsItem?>? = null
)

data class JsonMember264134(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember1(

	@field:SerializedName("fills")
	val fills: List<Any?>? = null
)

data class JsonMember69(

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("lineHeightPx")
	val lineHeightPx: Any? = null,

	@field:SerializedName("lineHeightPercentFontSize")
	val lineHeightPercentFontSize: Any? = null,

	@field:SerializedName("lineHeightUnit")
	val lineHeightUnit: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontSize")
	val fontSize: Any? = null,

	@field:SerializedName("lineHeightPercent")
	val lineHeightPercent: Any? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null
)

data class JsonMember13137(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("componentSetId")
	val componentSetId: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember264201(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class BoundVariables(
	val any: Any? = null
)

data class AbsoluteRenderBounds(

	@field:SerializedName("x")
	val x: Any? = null,

	@field:SerializedName("width")
	val width: Any? = null,

	@field:SerializedName("y")
	val y: Any? = null,

	@field:SerializedName("height")
	val height: Any? = null
)

data class AbsoluteBoundingBox(

	@field:SerializedName("x")
	val x: Any? = null,

	@field:SerializedName("width")
	val width: Any? = null,

	@field:SerializedName("y")
	val y: Any? = null,

	@field:SerializedName("height")
	val height: Any? = null
)

data class Components(

	@field:SerializedName("1586:296")
	val jsonMember1586296: JsonMember1586296? = null,

	@field:SerializedName("1586:317")
	val jsonMember1586317: JsonMember1586317? = null,

	@field:SerializedName("1:223")
	val jsonMember1223: JsonMember1223? = null,

	@field:SerializedName("1586:216")
	val jsonMember1586216: JsonMember1586216? = null,

	@field:SerializedName("13:137")
	val jsonMember13137: JsonMember13137? = null,

	@field:SerializedName("13:84")
	val jsonMember1384: JsonMember1384? = null
)

data class JsonMember1223(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember1382(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class ComponentSets(

	@field:SerializedName("13:136")
	val jsonMember13136: JsonMember13136? = null
)

data class JsonMember1384(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class JsonMember494(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class StrokesItem(

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("blendMode")
	val blendMode: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Document(

	@field:SerializedName("children")
	val children: List<ChildrenItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("scrollBehavior")
	val scrollBehavior: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class JsonMember122468(

	@field:SerializedName("styleType")
	val styleType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class BackgroundColor(

	@field:SerializedName("a")
	val a: Any? = null,

	@field:SerializedName("r")
	val r: Any? = null,

	@field:SerializedName("b")
	val b: Any? = null,

	@field:SerializedName("g")
	val g: Any? = null
)

data class JsonMember1586216(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class Constraint(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: Any? = null
)

data class JsonMember1586317(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("documentationLinks")
	val documentationLinks: List<Any?>? = null,

	@field:SerializedName("remote")
	val remote: Boolean? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class Offset(

	@field:SerializedName("x")
	val x: Any? = null,

	@field:SerializedName("y")
	val y: Any? = null
)

data class ArcData(

	@field:SerializedName("endingAngle")
	val endingAngle: Any? = null,

	@field:SerializedName("innerRadius")
	val innerRadius: Any? = null,

	@field:SerializedName("startingAngle")
	val startingAngle: Any? = null
)

data class StyleOverrideTable(

	@field:SerializedName("7")
	val jsonMember7: JsonMember7? = null,

	@field:SerializedName("8")
	val jsonMember8: JsonMember8? = null,

	@field:SerializedName("9")
	val jsonMember9: JsonMember9? = null,

	@field:SerializedName("10")
	val jsonMember10: JsonMember10? = null,

	@field:SerializedName("68")
	val jsonMember68: JsonMember68? = null,

	@field:SerializedName("69")
	val jsonMember69: JsonMember69? = null,

	@field:SerializedName("70")
	val jsonMember70: JsonMember70? = null
)

data class LayoutGridsItem(

	@field:SerializedName("visible")
	val visible: Boolean? = null,

	@field:SerializedName("sectionSize")
	val sectionSize: Any? = null,

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("offset")
	val offset: Any? = null,

	@field:SerializedName("pattern")
	val pattern: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("gutterSize")
	val gutterSize: Any? = null,

	@field:SerializedName("alignment")
	val alignment: String? = null
)

data class JsonMember68(

	@field:SerializedName("inheritFillStyleId")
	val inheritFillStyleId: String? = null,

	@field:SerializedName("fontFamily")
	val fontFamily: String? = null,

	@field:SerializedName("lineHeightPx")
	val lineHeightPx: Any? = null,

	@field:SerializedName("lineHeightPercentFontSize")
	val lineHeightPercentFontSize: Any? = null,

	@field:SerializedName("letterSpacing")
	val letterSpacing: Any? = null,

	@field:SerializedName("lineHeightUnit")
	val lineHeightUnit: String? = null,

	@field:SerializedName("fontPostScriptName")
	val fontPostScriptName: String? = null,

	@field:SerializedName("fontSize")
	val fontSize: Any? = null,

	@field:SerializedName("lineHeightPercent")
	val lineHeightPercent: Any? = null,

	@field:SerializedName("fontWeight")
	val fontWeight: Int? = null,

	@field:SerializedName("fills")
	val fills: List<FillsItem?>? = null
)

data class OverridesItem(

	@field:SerializedName("overriddenFields")
	val overriddenFields: List<String?>? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Property1(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("boundVariables")
	val boundVariables: BoundVariables? = null
)

data class Color(

	@field:SerializedName("a")
	val a: Any? = null,

	@field:SerializedName("r")
	val r: Any? = null,

	@field:SerializedName("b")
	val b: Any? = null,

	@field:SerializedName("g")
	val g: Any? = null
)
