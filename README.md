# Project Overview [EN]
This project encompasses the Twitter API integration that I worked on during my internship and plan to continue developing.
## Features
- **Profile Tweet Retrieval:** Currently, it allows fetching tweets from a specified Twitter user's profile, based on the specified number of pages, and storing them in a database.
- **Hashtag Search:** It enables retrieving and storing a specified number of tweets from a desired topic by performing a search using a particular hashtag.

## Structure
The project consists of the following three main classes to provide its functionality:

- **TwitterAPI:** The core class responsible for handling fundamental Twitter API functionalities.
- **DatabaseHandler:** A class utilized for storing and managing tweet data.
- **App:** The primary application class that initializes and coordinates the project's workflow.

## Utilized Libraries

The necessary libraries that ensure the project's functionality are specified through Maven in the **'pom.xml'** file.

## Usage

To utilize this project, you will need a Twitter Developer account and the corresponding API keys. These API keys are defined within the project's **'const'** as indicated.

-------------------------------------------------------------------------------------------------

# Proje Genel Bakış [TR]
Bu proje, staj sürecimde üzerinde çalıştığım ve geliştirmeye devam etmeyi planladığım Twitter API entegrasyonunu içermektedir.
## Özellikler
- **Profil Tweetleri Çekme:** Şu an için belirtilen bir Twitter kullanıcısının profilindeki belirttiğimiz sayfa sayısınca tweetlerini çekip veritabanına kaydetme özelliği bulunmaktadır.
- **Hashtag Arama:** Belirli bir hashtag ile arama yaparak istenilen başlıktaki belirtilen sayıdaki tweetleri çekip kaydetme özelliği mevcuttur.

## Yapı
Proje, işlevselliği sağlamak için aşağıdaki üç ana sınıftan oluşmaktadır:

- **TwitterAPI:** Temel Twitter API işlevselliğini sağlayan sınıf.
- **VeritabanıHandler:** Tweet verilerini depolamak ve yönetmek için kullanılan sınıf.
- **App:** Projenin çalışmasını başlatan ve koordine eden ana uygulama sınıfı.

## Kullanılan Kütüphaneler

Projenin işlevselliğini sağlamak için gerekli olan kütüphaneler **'pom.xml'** dosyasında Maven aracılığıyla belirtilmiştir.

## Kullanım

Projeyi kullanabilmek için Twitter Developer hesabına ve ilgili API anahtarlarına ihtiyacınız olacaktır. Bu API anahtarları, projenin **'const'** içinde tanımlandığı şekilde belirtilmiştir.
