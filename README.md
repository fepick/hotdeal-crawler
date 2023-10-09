아카라이브 핫딜 게시판 크롤러
=====================
패스트캠퍼스 커널360 1기 사전과제로 만든 간단한 크롤러입니다.
아카라이브 핫딜 게시판의 원하는 페이지만큼을 크롤링해 xlsx 파일로 변환해 저장합니다
어떤 제품의 장기적인 시세를 관찰하고 적절한 시기와 적절한 가격에 물건을 구매하는 데 활용합니다.
준비기간 : 2주 / 제작기간 : 5시간

#구현된 클래스
1. HotDealScrapper : 메인함수가 포함된 클래스입니다.
  1) Jsoup으로 페이지를 크롤링해 필요한 정보를 추출합니다.
  2)추출한 데이터를 ExcelExporter로 처리합니다.
2. HotDealVO : 핫딜 게시글의 주요 상태정보와 생성자, getter, tostring 함수를 포함하는 VO입니다.
3. ExcelExporter : HotDealVO의 Array를 받아 xlsx파일로 저장하는 역할을 합니다.

#개발도구
gradle, Jsoup, Apache POI

#개선할 사항
1. 게시글 작성 시간을 크롤링해, 그것을 DateTime으로 파싱해 사용
2. PDF로 추출하는 PdfExporter 클래스 생성
3. HotDealParser 클래스를 따로 분리해 HotDealScrapper 클래스의 가독성 높이기
4. 하나의 엑셀파일에 export할 수 있도록 하는 기능 추가
5. 원하는 키워드로 검색해 크롤링하는 기능 추가
