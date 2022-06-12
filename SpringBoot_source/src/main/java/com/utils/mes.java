package com.utils;

public class mes {

	public enum Align {
		start("text-star"), center("text-center"), end("text-end");
		
		String value = "text-start";

		private Align(String value) {
			this.value = value;
		}
	}
	
	public enum Color {
		black("text-dark"), red("text-danger"), green("text-success"), 
		blue("text-primary"), yellow("text-warning"), muted("text-muted");
		
		String value = "text-dark";

		private Color(String value) {
			this.value = value;
		}
	}

	public static String newMes(Align align, Color color, String... messages) {
		StringBuilder str = new StringBuilder();
		if (messages.length < 2) { // for one
			str.append("<spant").append(" class=\"");
			str.append(align.value).append(" ").append(color.value).append("\"").append(">");
			str.append(messages[0]).append("</span>");
		} else { // more message
			str.append("<ul").append(" class=\"");
			str.append(align.value).append(" ").append(color.value).append("\"").append(">");
			for (String string : messages) {
				str.append("<li>").append(string).append("</li>");
			}
			str.append("</ul>");
		}
		return str.toString();
	}
}
