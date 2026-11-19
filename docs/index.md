---
title: Overview
description: "Summary of in-progress or completed project."
order: 0
---

{% include ddc-abbreviations.md %}

## Page contents
{:.no_toc}

{.collapsible}
- ToC
{:toc}

## Summary

This project is a Java+Kotlin implementation of a simple chat application, with these main components:

- A RESTful web service backed by a relational data store, built with Spring Boot, Spring MVC, Spring Data, Jackson, OpenAPI, and H2.

- A client app built on the Android platform, using Android JetPack, Retrofit, OpenAPI, and Moshi. 

## Intended users and user stories

- Full-stack software development learners

    > As a developer looking to improve my understanding of client-server architecture on the web, I want to build and use an application that follows the RESTful pattern for client-server communication, so that I can gain experience with the relevant protocols, architectural & design patterns, and implementation approaches.
    
- Java programmers learning Kotlin

    > I have some experience in Spring and Android with Java, but I have read that implementation of some design patterns, and of specific components, can be simplified with Kotlin. I want to build a mixed-language, multi-tier application with both Java and Kotlin, to deepen my understanding of both languages---especially of their relative strengths, weaknesses, and interoperability.

## Functionality

The functionality will be roughly equivalent to that of a very simplified IRC (Internet Relay Chat) client and server, with these specific constraints: 

- No direct or private messages.

- The list of available channels will be fixed; there will be no capability to create new channels.

- In the initial implementation, users will not be authenticated, but will identify themselves entirely by their nicknames.

- When joining a channel, history for the past 30 minutes will be available, and can be displayed by the client app.

- The client app will present the necessary controls to allow the user to select---and switch between---channels, to scroll through the history (up to 30 minutes) of conversation.

- No ANSI terminal codes (for color, etc.) will be supported.

## Persistent data

In the initial implementation, there will be two entities, with the attributes shown:

- `channel`

    | Keys | Attribute | Type | Additional constraints |
    |:-:|:-|:-:|:-|
    | PK | `channel_id` | `Long` | |
    | UK1 | `external_key` | `UUID` | |
    | UK2 | `name` | `String` | `max length = 50` |
    | | `description` | `String` | (Nullable)|
    |IX1 | `created`| `Instant` | |
    
- `message`

    | Keys | Attribute | Type | Additional constraints |
    |:-:|:-|:-:|:-|
    | PK | `message_id` | `Long` | |
    | UK1 | `external_key` | `UUID` | |
    | | `sender` | `String` | `max length = 50` |
    | | `content` | `String` | |
    | FK1, IX1 | `channel_id`|`Long` | Foreign key ref to `channel.channel_id`|
    |IX1 | `stored` | `Instant` | |

## Device/external services

(None at this time.)

## Stretch goals and possible enhancements 

- Add authentication via an OAuth2.0 provider (e.g., Google). All messages will not only include the sender's nickname, but will also refer to the authenticated user.

- Add support for Markdown rendering in messages.