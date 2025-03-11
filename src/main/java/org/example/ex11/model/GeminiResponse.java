package org.example.ex11.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Gemini API 응답을 위한 Record 클래스
 * API 응답 구조에 맞게 설계되었습니다.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record GeminiResponse(List<Candidate> candidates) {

    /**
     * Gemini API 응답의 candidate 객체를 표현하는 Record
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Candidate(Content content) {
    }

    /**
     * Candidate 내부의 content 객체를 표현하는 Record
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Content(List<Part> parts) {
    }

    /**
     * Content 내부의 part 객체를 표현하는 Record
     * Jakarta Servlet의 Part와 충돌을 피하기 위해 내부 클래스로 정의
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Part(String text) {
    }
}