# The main search query is included within the query object. 
# As we will see later, we can add different types of search queries 
# to this object. For each query, we add a key with the query type 
# (match_all in this example), with the value being an object containing 
# the search options. There are no options in this example as we want to 
# return all of the documents in the index.

# In addition to the query object, the search body can contain other optional
# properties, including size and from. The size property determines the number 
# of documents to be included in the response. If this value is not present, 
# by default ten documents are returned. 
# The from property determines the starting index of the returned documents. 
# This is useful for pagination.

# {
#     "size": 20,
#     "from": 0,
#     "query": {
#       "match_all": {}
# }


# Match documents that contain specific values in a field
# The above search query returns documents whose title field matches any words in the queryproperty. 
# We can set a minimum number of matched terms as follows.

# -------------------------------------------------------
# {
#   query: {
#     match: {
#       title: {
#         query: 'search terms go here',
#       }
#     }
#   }
# }

# The above search query returns documents whose title field matches any words in the queryproperty. 
# We can set a minimum number of matched terms as follows.
# -------------------------------------------------------
# {
#   query: {
#     match: {
#       title: {
#           query: 'search terms go here',
#           minimum_should_match: 3
#       }
#     }
#   }
# }

# This query matches documents that have at least three of the specified words 
# in their title. If there are less than three words in the query, 
# all must be present in the title for the document to be matched. 
# Another useful feature to add to search queries is fuzziness. 
# This is useful if the user makes a typo in writing the query, 
# as fuzzy matching will find closely spelled terms. 
# -------------------------------------------------------
# {
#   query: {
#       match: {
#           title: {
#               query: 'search tems go here',
#               minimum_should_match: 3,
#               fuzziness: 2
#           }
#       } 
#   }
# }

# Search within multiple fields
# -------------------------------
# If you want to search within multiple fields, 
# the multi_match search type can be used. 
# It is similar to match, except instead of having the field as a 
# key in the search query object, we add a fields key, which is an 
# array of fields to be searched. Here, we search within the title, 
# authors.firstname, and authors.lastname fields

# The multi_match query supports other search properties such as 
# minimum_should_match and fuzziness. Elasticsearch supports 
# wildcards (e.g., *) for matching multiple fields, 
# so we can shorten the above example to ['title', 'authors.*name'].

# multi_match: {
#   query: 'search terms go here',
#   fields: ['title', 'authors.firstname',  'authors.lastname']
# }



# Matching a complete phrase
# ----------------------------------------------------------------------
# Elasticsearch can also match a phrase exactly as entered, 
# without matching at term level. This query is an extension 
# to the regular match query, called match_phrase. 
# Below is an example of a match_phrase. (link to source)
# match: {
#   title: {
#     query: 'search phrase goes here',
#     type: 'phrase'
#   }
# }

# Combining multiple queries
#  ----------------------------------------------------------
# So far, in the examples we have only used a single query per request. 
# Elasticsearch however, allows you to combine multiple queries. 
# The most common compound query is bool. The bool query accepts four types 
# of keys: must, should, must_not, and filter. As their names imply, documents 
# in the results must match queries within must, must not match queries 
# within must_not, and will get a higher score if they match queries within 
# should. Each one of the mentioned elements can receive multiple search 
# queries in the form of an array of queries.

# Below, we use bool query along with a new query type called query_string. 
# This allows you to write more advanced queries using keywords such as AND 
# and OR. The complete documentation for the query_string syntax can be found 
# here. In addition, we use the range query (documentation here), which allows 
# us to restrict a field to a given range.

# {
#   bool: {
#     must: [
#       {
#         query_string: {
#           query: '(authors.firstname:term1 OR authors.lastname:term2) AND (title:term3)'
#         }
#       }
#     ],
#     should: [
#       {
#         match: {
#           body: {
#             query: 'search phrase goes here',
#             type: 'phrase'
#           }
#         }
#       }
#     ],
#     must_not: [
#       {
#         range: {
#           year: {
#             gte: 2011,
#             lte: 2013
#           }
#         }
#       }
#     ]
#   }
# }

# Filters
# Staying with the example above, imagine that we want to limit the 
# results of our search to articles published between 2011 and 2015. 
# To do this, we only need to add a range query to the filter section 
# of the original search query. This will remove any unmatched documents 
# from the results. 

# {
#   bool: {
#     must: [
#       {
#         match: {
#           title: 'search terms go here'
#         }
#       }
#     ],
#     filter: [
#       {
#         range: {
#           year: {
#             gte: 2011,
#             lte: 2015
#           }
#         }
#       }
#     ]
#   }
# }


# ----------------------------------------------------------------------
# GET mdeforge.users/_search

# GET mdeforge.workspaces/_search

# GET mdeforge.projects/_search

# GET mdeforge.metamodels/_search
# {
#   "query": {
#     "query_string": {
#       "default_field": "content", 
#       "query": "(upperBound=\"-1\" eType=\"#//command/IAdvise\") AND mounted AND name"
#     }
#   }
# }

# #{
# #  "query": {
# #    "match_phrase": {
# #      "_id": "6231c37c185f1e00140ece30"
# #    }
# #  }
# #}

# GET mdeforge.models/_search
# {
#   "size": -1
# }

# GET mdeforge.dsls/_search

# # =======================================================================
# GET mdeforge.*/_search
# {
#   "size": -1,
#   "query": {
#     "bool": {
#       "must": [
#         {
#           "match_phrase": {
#             "ext": "ECORE"
#           }
#         }
#       ]
#     }
#   }
# } 

# DELETE mdeforge.*


# # =======================================================================

# GET mdeforge.users/_search
# {
#   "query": {
#     "match_phrase": {
#       "_id": "62276d532420ff001363643f"
#     }
#   }
# }

# GET mdeforge.workspaces/_search
# {
#   "query": {
#     "match_phrase": {
#       "owner": "62276d532420ff001363643f"
#     }
#   }
# }

# GET mdeforge.metamodels/_search
# {
#   "query": {
#     "match": {
#       "content": "<eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"elements\" upperBound=\"-1\" eType=\""
#     }
#   }
# }

# GET mdeforge.models/_search
# {
#   "query": {
#     "match": {
#       "content": "MaxWaitingTime"
#     }
#   }
# }


# GET mdeforge.*/_search
# {
#   "query": {
#     "match": {
#         "content": "xmi"
#     }
#   }
# }

# GET mdeforge.models/_search


# GET mdeforge.workspaces/_search

# GET mdeforge.projects/_search




# GET mdeforge.metamodels/_search
# {
#   "query": {
#     "match": {
#         "name": "SimpleOOP.ecore"
#     }
#   }
# }

# GET mdeforge.transformations/_search

# GET mdeforge.artifacts/_search
# {
#   "query": {
#     "match": {
#       "_id": "62163188274bb50013cc3aa0"
#     }
#   }
# }

# DELETE car
# GET car/_search
# {
#   "query": {
#     "bool": {
#       "must": {
#         "match_all": {}
#       },
#       "filter": {
#         "range": {
#           "Year": {
#             "gte": "1970-01-01",
#             "lte": "1971-01-01"
#           }
#         }
#       }
#     }
#   }
# }

# GET mdeforge.metamodels/_search
# {
#   "query": {
#     "match": {
#       "type": {
#         "query": "ECORE"
#       }
#     }
#   }
# }

# GET mdeforge.artifacts/_search
# {
#   "query": {
#     "match": {
#       "_id": "621534db9bce65001393d400"
#     }
#   }
# }


# GET mdeforge.models/_search
# {
#   "from": 5,
#   "size": 3
# }

# # The filter clause
# GET car/_search
# {
#   "query": {
#     "bool": {
#       "filter": {
#         "range": {
#           "date": {
#             "gte": "1971-01-01",
#             "lte": "1977-01-01"
#           }
#         }
#       }
#     }
#   }
# }

# # ************************************************************

# GET _cat/indices

# GET car/_search


# ################################################################################################

# # Get info about cluster health
# GET _cluster/health

# # Get info about nodes in a cluster
# GET _nodes/stats

# # Example post
# # 1. Use POST when you want Elasticsearch to autogenerate an id for your document.

# POST favorite_candy/_doc
# {
#   "first_name": "Lisa",
#   "candy": "Sour Skittles",
#   "date": "2015-06-20"
# }

# # 2. Use PUT when you want to assign a specific id to your document
# PUT favorite_candy/_doc/1
# {
#   "first_name": "John",
#   "candy": "Starburst",
#    "date": "2018-09-22"
# }

# # Read a document
# GET favorite_candy/_doc/1


# # Retrieve information about documents in an index
# GET favorite_candy/_search?q=John

# # Delete all documents
# DELETE favorite_candy

# # Delete a document
# DELETE favorite_candy/_doc/1

# # return all documents from the favorite_candy index
# GET favorite_candy/_search
# {
#   "query": {
#     "match_all": {}
#   }
# }

# # Get the exact total number of hits
# #To improve the response speed on large datasets, Elasticsearch limits the total count to 10,000 by default. 
# # If you want the exact total number of hits, use the following query.
# GET favorite_candy/_search
# {
#   "track_total_hits": true
# }

# # Search for data within a specific time range
# GET favorite_candy/_search
# {
#   "query": {
#     "range": {
#       "date": {
#         "gte": "2015-06-20",
#         "lte": "2019-09-22"
#       }
#     }
#   }
# }

# # Aggregations
# # An aggregation summarizes your data as metrics, statistics, and other analytics.

# GET favorite_candy/_search
# {
#   "query": {
#     "match": {
#       "first_name": "John"
#     }
#   }
# }

# # --------------------------------------------------------------------------------------------
# # Insert data in elastic
# POST news_headlines/_doc 
# {
#   "date": "3/6/2021",
#   "short_description": "Twin preg, unsp num plcnta & amnio sacs, first trimester",
#   "link": "https://storify.com/at/feugiat/non.js",
#   "category": "Support",
#   "headline": "Remov cholecystost tube",
#   "authors": "Aonyx capensis"
# }

# # Get the exact total number of hits
# GET news_headlines/_search
# {
#   "track_total_hits": true
# }

# GET news_headline/_search


# # DELETE news_headline


# # Search for data within a specific time range
# GET news_headlines/_search
# {
#   "query": {
#     "range": {
#       "date": {
#         "gte": "5/27/2021",
#         "lte": "7/29/2021"
#       }
#     }
#   }
# }


# # Aggregations
# # Analyze the data to show the categories of news headlines in our dataset
# GET news_headlines/_search
# {
#   "query": {
#     "match": {
#       "category": "Product Management"
#     }
#   },
#   "aggregations": {
#     "popular_in_entertainment": {
#       "significant_text": {
#         "field": "headline"
#       }
#     }
#   }
# }

# # minimum_should_match
# # This parameter allows you to specify the minimum number of terms a document should have to be included in the search results.
# GET news_headlines/_search
# {
#   "query": {
#     "match": {
#       "headline": {
#         "query": "Stapes mobilization",
#         "minimum_should_match": 1
#       }
#     }
#   }
# }

# # Precision and Recall
# GET news_headlines/_search
# {
#   "query": {
#     "match": {
#       "headline": {
#         "query": "Stapes"
#       }
#     }
#   }
# }

# # We can increase precision by adding an "and" operator to the query.
# # "AND" operator will result in getting more precise matches, thereby increasing precision. 
# # However, it will reduce the number of hits returned, resulting in lower recall.
# GET news_headlines/_search
# {
#   "query": {
#     "match": {
#       "headline": {
#         "query": "stapes",
#         "operator": "and"
#       }
#     }
#   }
# }

# # Get information about documents in an index
# GET news_headlines/_search

# # Searching for a phrase
# GET news_headlines/_search
# {
#   "query": {
#     "match": {
#       "headline": {
#         "query": "Cl"
#       }
#     }
#   }
# }

# # Searching for phrases using the match_phrase query
# GET news_headlines/_search
# {
#   "query": {
#     "match_phrase": {
#       "headline": {
#         "query": "reduc"
#       }
#     }
#   }
# }

# # Running a match query against multiple fields
# GET news_headlines/_search
# {
#   "query": {
#     "multi_match": {
#       "query": "fx",
#       "fields": [
#         "headline",
#         "short_description",
#         "authors"
#       ]
#     }
#   }
# }

# # Improving precision with phrase type match
# GET news_headlines/_search
# {
#   "query": {
#     "multi_match": {
#       "query": "fx",
#       "fields": [
#         "headline^2",
#         "short_description"
#       ],
#       "type": "phrase"
#     }
#   }
# }

# # Aggregation
# GET news_headlines/_search
# {
#   "aggregations": {
#     "by_category": {
#       "terms": {
#         "field": "category.keyword",
#         "size": 100
#       }
#     }
#   }
# }

# # Bool Query
# # The bool query retrieves documents matching boolean combinations of other queries.
# # There are four clauses to choose from:
# #    must
# #    must_not
# #    should
# #    filter
# GET news_headline/_search
# {
#   "query": {
#     "match_phrase": {
#       "category": "Marketing"
#     }
#   },
#   "aggregations": {
#     "category_mentions": {
#       "terms": {
#         "field": "category.keyword",
#         "size": 100
#       }
#     }
#   }
# }

# # The must clause
# GET news_headlines/_search
# {
#   "query": {
#     "bool": {
#       "must": [
#         {
#         "match_phrase": {
#           "headline": "fix"
#          }
#         },
#         {
#           "match": {
#             "category.keyword": "Sales"
#           }
#         }
#       ]
#     }
#   }
# }

# # The must_not clause
# GET news_headlines/_search
# {
#   "query": {
#     "bool": {
#       "must": {
#         "match_phrase": {
#           "headline": "site"
#          }
#         },
#        "must_not":[
#          {
#           "match": {
#             "category": "Business Development"
#           }
#         }
#       ]
#     }
#   }
# }


# # The should clause
# # if a document contains the phrase "site" in the field category, this document should be given 
# # a higher score and should be placed higher in the search results.
# # all hits MUST contain "site" in the field headline.

# GET news_headlines/_search
# {
#   "query": {
#     "bool": {
#       "must": [
#         {
#         "match_phrase": {
#           "headline": "site"
#           }
#          }
#         ],
#        "should":[
#          {
#           "match_phrase": {
#             "category": "Business Development"
#           }
#         }
#       ]
#     }
#   }
# }

# # The filter clause
# GET news_headlines/_search
# {
#   "query": {
#     "bool": {
#       "must": [
#         {
#           "match_phrase": {
#             "headline": "site"
#           }
#         }
#       ],
#       "filter": {
#         "range": {
#           "date": {
#             "gte": "5/27/2021",
#             "lte": "7/29/2021"
#           }
#         }
#       }
#     }
#   }
# }


# # Adding multiple queries under the should clause
# GET news_headlines/_search
# {
#   "query": {
#     "bool": {
#       "must": [
#         {
#           "match_phrase": {
#             "headline": "site"
#           }
#         }
#       ],
#       "should": [
#         {
#           "match": {
#             "headline": "site"
#           }
#         },
#         {
#           "match": {
#             "short_description": "ship"
#           }
#         },
#         {
#           "match": {
#             "headline": "site"
#           }
#         }
#       ]
#     }
#   }
# }

# # #####################################################################################################
# GET ecommerce_data/_search

# DELETE ecommerce_data

# # STEP 1: Create a new index(ecommerce_data) with the following mapping.
# PUT ecommerce_data
# {
#   "mappings": {
#     "properties": {
#       "Country": {
#         "type": "keyword"
#       },
#       "CustomerID": {
#         "type": "long"
#       },
#       "Description": {
#         "type": "text"
#       },
#       "InvoiceDate": {
#         "type": "date"
#       },
#       "InvoiceNo": {
#         "type": "keyword"
#       },
#       "Quantity": {
#         "type": "long"
#       },
#       "StockCode": {
#         "type": "keyword"
#       },
#       "UnitPrice": {
#         "type": "double"
#       }
#     }
#   }
# }

# # STEP 2: Reindex the data from the original index(source) to the one you just created(destination).
# POST _reindex
# {
#   "source": {
#     "index": "ecommerce_dat"
#   },
#   "dest": {
#     "index": "ecommerce_data"
#   }
# }

# # STEP 3: Remove the negative values from the field "UnitPrice".
# POST ecommerce_data/_delete_by_query
# {
#   "query": {
#     "range": {
#       "UnitPrice": {
#         "lte": 0
#       }
#     }
#   }
# }

# # STEP 4: Remove values greater than 500 from the field "UnitPrice".
# POST ecommerce_data/_delete_by_query
# {
#   "query": {
#     "range": {
#       "UnitPrice": {
#         "gte": 500
#       }
#     }
#   }
# }

# # Aggregations: summarizes your data as metrics, statistics and other analytics
# # Get me the summary of monthly revenue generated from Germany
# GET ecommerce_data/_search


# # Metric Aggregations
# GET ecommerce_data/_search
# {
#   "aggs": {
#     "sum_unit_price": {
#       "sum": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }


# # Using a size parameter
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "sum_unit_price": {
#       "sum": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# # Compute the lowest(min) or max unit price of an item
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "lowest_unit_price": {
#       "min": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "lowest_unit_price": {
#       "max": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# # Average
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "average_unit_price": {
#       "avg": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# # Aggregation: Compute the count, min, max, avg, sum in one go
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "all_stats_unit_price": {
#       "stats": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# # Cardinality Aggregation, there are 1000 unique number of customers in our index.
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "number_unique_customers": {
#       "cardinality": {
#         "field": "CustomerID"
#       }
#     }
#   }
# }

# # Limiting the scope of an aggregation
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "query": {
#     "match": {
#       "country": "Germany"
#     }
#   },
#   "aggs": {
#     "germany_average_unit_price": {
#       "avg": {
#         "field": "UnitPrice"
#       }
#     }
#   }
# }

# # Fixed_interval With the fixed_interval, the interval is always constant.
# # Example: Create a bucket for every 8 hour interval.
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_by_8_hrs": {
#       "date_histogram": {
#         "field": "InvoiceDate",
#         "fixed_interval": "8h"
#       }
#     }
#   }
# }

# # Calendar_interval With the calendar_interval, the interval may vary.
# # Ex. Split data into monthly buckets.
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_by_month": {
#       "date_histogram": {
#         "field": "InvoiceDate",
#         "calendar_interval": "1M"
#       }
#     }
#   }
# }

# # Bucket sorting for date histogram aggregation
# # By default, the date_histogram aggregation sorts buckets based on the "key" values in ascending order.

# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_by_month": {
#       "date_histogram": {
#         "field": "InvoiceDate",
#         "calendar_interval": "1M",
#         "order": {
#           "_key": "desc"
#         }
#       }
#     }
#   }
# }

# # Ex. Create a buckets based on price interval that increases in increments of 10.
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_per_price_interval": {
#       "histogram": {
#         "field": "UnitPrice",
#         "interval": 10
#       }
#     }
#   }
# }

# # Bucket sorting for histogram aggregation
# # By default, the histogram aggregation sorts buckets based on the _key values in ascending order. 
# # To reverse this order, you can add an order parameter to the aggregation. 
# # Then, specify that you want to sort buckets based on the _key values in descending(desc) order!

# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_per_price_interval": {
#       "histogram": {
#         "field": "UnitPrice",
#         "interval": 10,
#         "order": {
#           "_key": "desc"
#         }
#       }
#     }
#   }
# }

# # Range Aggregation
# # For example, what if you wanted to know the number of transactions for items from varying price ranges(between 0 and $50, between $50-$200, and between $200 and up)?
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_per_custom_price_ranges": {
#       "range": {
#         "field": "UnitPrice",
#         "ranges": [
#           {
#             "to": 50
#           },
#           {
#             "from": 50,
#             "to": 200
#           },
#           {
#             "from": 200
#           }
#         ]
#       }
#     }
#   }
# }


# # For example, let's say you want to identify 5 customers with the highest number of transactions(documents).
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "top_5_customers": {
#       "terms": {
#         "field": "CustomerID",
#         "size": 5
#       }
#     }
#   }
# }


# # For example, let's say you wanted to calculate the daily revenue and the number of unique customers per day in one go. To do this, you can add multiple metric aggregations per bucket as shown below!
# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_per_day": {
#       "date_histogram": {
#         "field": "InvoiceDate",
#         "calendar_interval": "day"
#       },
#       "aggs": {
#         "daily_revenue": {
#           "sum": {
#             "script": {
#               "source": "doc['UnitPrice'].value * doc['Quantity'].value"
#             }
#           }
#         },
#         "number_of_unique_customers_per_day": {
#           "cardinality": {
#             "field": "CustomerID"
#           }
#         }
#       }
#     }
#   }
# }


# # Sorting by metric value of a sub-aggregation
# # You do not always need to sort by time interval, numerical interval, or by doc_count! You can also sort by metric value of sub-aggregations.
# # Let's take a look at the request below. Within the sub-aggregation, metric values "daily_revenue" and "number_of_unique_customers_per_day" are calculated.
# # Let's say you wanted to find which day had the highest daily revenue to date!
# # All you need to do is to add the "order" parameter( and sort buckets based on the metric value of "daily_revenue" in descending("desc") order!


# GET ecommerce_data/_search
# {
#   "size": 0,
#   "aggs": {
#     "transactions_per_day": {
#       "date_histogram": {
#         "field": "InvoiceDate",
#         "calendar_interval": "day",
#         "order": {
#           "daily_revenue": "desc"
#         }
#       },
#       "aggs": {
#         "daily_revenue": {
#           "sum": {
#             "script": {
#               "source": "doc['UnitPrice'].value * doc['Quantity'].value"
#             }
#           }
#         },
#         "number_of_unique_customers_per_day": {
#           "cardinality": {
#             "field": "CustomerID"
#           }
#         }
#       }
#     }
#   }
# }




# GET news_headlines/_search?q=Accounting





# ######################################################################################################
# POST ecommerce_data/_delete_by_query
# {
#   "query": {
#     "range": {
#       "UnitPrice": {
#         "gte": 500
#       }
#     }
#   }
# }





# # -----------------------------------------------------

# # Mapping

# POST userdata/_create/1 
# {
#   "name":"arsene",
#   "dob": "1990-12-05",
#   "place": "Rwanda",
#   "job_desc": "President of Indamutsa Holdings limited"
# }

# PUT userdata
# {
#   "mappings": {
#     "properties": {
#       "dob": {
#         "type": "date"
#       },
#       "job_desc": {
#         "type": "text",
#         "index": true
#       }
#     }
#   }
# }

# GET userdata/_search?q=president


# DELETE userdata






# # -------------------------------------

# GET mdeforge.users/_search

# GET /_cat/health

# GET mdeforge.metamodels/_search

# GET mdeforge.server_logs/_search

# GET testdb.kittens/_search
# {
#   "size": 1000
# }


# GET mdeforge.artifacts/_mapping

# # ---------------------------------------------------------

# # To get all indices
# GET /_cat/indices


# #TO get data from a given indices
# GET /netflix/_search

# #To get a single doc
# GET /netflix/_doc/2sK0BH0B_98CjIUDAnO2


# GET /netflix/_search/?q="seasons"

# GET /test.kittens/_search

# # This is our scaffold generator
# # must is like AND op
# # must_not is like NOT op
# # should is like OR op
# # filter is filter


# GET /netflix/_search
# {
#   "_source": [],
#   "size": 10,
#   "min_score": 0.5,
#   "query": {
#     "bool": {
#       "must": [],
#       "filter": [],
#       "should": [],
#       "must_not": []
#     }
#   }
# }


# # To get only title
# # source is the properies, you want, they are listed as text in source
# # size: the number of document to return
# # min score of a document to be returned
# # For instancem we search for the world killer in field title
# # When u add more query, it means AND operator
# GET /netflix/_search
# {
#   "_source": [
#     "title"
#   ],
#   "size": 10,
#   "min_score": 0.5,
#   "query": {
#     "bool": {
#       "must": [
#         {
#           "match": {
#             "title": "Most"
#           }
#         },
#             {
#           "match": {
#             "title": "Violent"
#           }
#         }
#       ],
#       "filter": [],
#       "should": [],
#       "must_not": []
#     }
#   }
# }

# # THe or operator in should
# # Look for words titles that have the word most and violent but should not have must
# GET /netflix/_search
# {
#   "_source": [
#     "title"
#   ],
#   "size": 10,
#   "min_score": 0.5,
#   "query": {
#     "bool": {
#       "must": [],
#       "filter": [],
#       "should": [
#         {
#           "match": {
#             "title": "Most"
#           }
#         },
#         {
#           "match": {
#             "title": "Violent"
#           }
#         }
#       ],
#       "must_not": [
#                 {
#           "match": {
#             "title": "wanted"
#           }
#         }]
#     }
#   }
# }

# # MATCH AND MATCH PHRASE

# #Here we searching the world below in the field called duration
# GET /netflix/_search
# {
#   "query": {
#     "match": {
#       "duration": "54 min"
#     }
#   }
# }

# #Here we searching the world below in the field called title
# GET /netflix/_search
# {
#   "query": {
#     "match_phrase": {
#       "title": "Most Violent"
#     }
#   }
# }



# #Autocompletion query
# GET netflix/_search
# {
#   "_source": [],
#   "size": 10,
#   "min_score": 0.5,
#   "query": {
#     "bool": {
#       "must": [
#         {
#           "wildcard": {
#             "title": {
#               "value": "*"
#             }
#           }
#         }
#       ],
#       "filter": [],
#       "should": [],
#       "must_not": []
#     }
#   },
#   "aggs": {
#     "auto_complete": {
#       "terms": {
#         "field": "title.keyword",
#         "order": {
#           "_count": "asc"
#         },
#         "size": 20
#       }
#     }
#   }
# }

# GET netflix/_mapping

#-----------------------------------------------------


# /**
#  * MDEForgeQL is a powerful domain specific language used for querying models 
#  * in a cloud-based model repository. MDEForgeQL can be used to access quality assessment metrics, 
#  * chain transformation services and object model query services from third party providers. 
#  * This allows developers to create sophisticated queries that take advantage of 
#  * the best available services. 
#  * 
#  * This approach offers several benefits over traditional approaches to querying models. 
#  * First, it is more flexible and allows developers to select the most appropriate 
#  * quality assessment metric for their needs. This allows them to select the most appropriate metric for  their needs. 
#  * Second, it enables developers to access chain transformation services that can be used 
#  * to optimize their models. 
#  * Finally, it provides access to object model query services that can improve the efficiency of model 
#  * retrieval operations.
#  */

# Query User(username: "Value", userId: "Value")
# 	return [id, username, email, createdAt, updatedAt]
	
# Query Workspace(owner: "Value", workspaceId: "Value")
# 	return [id, name, owner, description, projects, createdAt, updatedAt]
	
# Query Project(username: "Value", userId:"Value", workspaceId:"Value", projectId:"Value")
# 	return [id, name, description, workspace, sharedUser, user, comments, createdAt, updatedAt]
	
# Query Metamodel(id:"Value", name: "Value", accessControl: 'value', operation: "value", ePackageName: "value")
# 	=> microSyntax('(roots heuristic systems) OR (enigneer~) OR (size:(>=10000 AND <=52000))')
# 	=> fullTextSearch('keyword keyword2' , operator: AND )
# 	=> filter( gte: 2000, lte: 2022, size: <= 2332)
# 	=> qualityMetrics(qa == 2 AND qb <= 2)
# 	=> transformable ( id: "value", name: "value")
# 	return [id, name, license, description]
	
# Query Model(id: "value")
# 	=> microSyntax('(roots heuristic systems) OR (enigneer~) OR (size:(>=10000 AND <=52000))')
# 	=> modelQuery(type: EOL, 'for (t in Tree.all) 
# 				{ t.label.println(); } 
# 				"We are printing in eshagdjas ol file".println(); 
# 				//Model.modelFile.println(); 
# 				doQuery().println(); 
# 				"I am talking with you".println(); 
# 				operation doQuery()
# 				{ return "HELLO WORLD"; }')
# 	=> filter( gte: 2000, lte: 2022, size: <= 2332)
# 	=> fullTextSearch('word1 word2' , min_match : 2 )
# 	return [id, name, license]
	
# Query Dsl(id: "value")
# 	=> microSyntax('(roots heuristic systems) OR (enigneer~) OR (size:(>=10000 AND <=52000))')
# 	=> filter( gte: 2000, lte: 2022, size: <= 2332)
# 	=> fullTextSearch('word1 word2' , operator: EXACT )
# 	return [id, name, license]	


# ---------------------------------------------------------------------

# grammar com.arsene.query.QueryDsl with org.eclipse.xtext.common.Terminals

# generate queryDsl "http://www.arsene.com/query/QueryDsl"

# QueryModel:
# 	elements+=AbstractElement*;

# AbstractElement:
# 	Variable | User | Workspace | Project | Metamodel | Model | Dsl;

# User:
# 	'Query' 'User' '(' uservar=UserVar (',' uservars+=UserVar)* ')'
# 	'return' '[' field=UserField (',' fields+=UserField)*']';

# Workspace:
# 	'Query' 'Workspace' '(' spacevar=WorkspaceVar (',' spacevars+=WorkspaceVar)* ')'
# 	'return' '[' field=WorkspaceField (',' fields+=WorkspaceField)*']';

# Project:
# 	'Query' 'Project' '(' projectvar=ProjectVar (',' projectvars+=ProjectVar)* ')'
# 	'return' '[' field=ProjectField (',' fields+=ProjectField)*']';

# Metamodel:
# 	'Query' 'Metamodel' '(' metamodelVar=MetamodelVar (',' metamodelVars+=MetamodelVar)* ')'
# 	('=>' (syntax=MicroSyntax | textSearch=FullTextSearch | filter=Filter | qm=QualityMetric | transfo=Transformable))*
# 	'return' '[' field=MetamodelField (',' fields+=MetamodelField)* ']';

# Model:
# 	'Query' 'Model' '(' modelVar=ModelVar (',' modelVars+=ModelVar)* ')'
# 	('=>' (syntax=MicroSyntax | textSearch=FullTextSearch | filter=Filter | q=ModelQuery))*
# 	'return' '[' field=ModelField (',' fields+=ModelField)* ']';

# Dsl:
# 	'Query' 'Dsl' '(' dslVar=DslVar (',' dslVars+=DslVar)* ')'
# 	('=>' (syntax=MicroSyntax | textSearch=FullTextSearch | filter=Filter))*
# 	'return' '[' field=DslField (',' fields+=DslField)* ']';

# //	('=>' (syntx=MicroSyntax | textSearch=FullTextSearch | filter=Filter | qm=QualityMetric | transfo=Transformable)?)*
# MicroSyntax:
# 	'microSyntax' '(' exp=Expression ')';

# ModelQuery:
# 	'modelQuery' '(' 'type' ':' QueryLang ',' expr=Expression ')';

# QueryLang:
# 	'EOL' | 'OCL';

# FullTextSearch:
# 	'fullTextSearch' '(' exp=Expression (',' exps+=Expression)* (',' 'min_match' ':' INT | ',' 'operator' ':'
# 	op=Operator)? ')';

# QualityMetric:
# 	'qualityMetrics' '(' qExp=QExp (operator=Operator qExps=QExp)* ')';

# Transformable:
# 	'transformable' '(' (param=TransParam ':' exp=Expression) (',' param=TransParam ':' exp=Expression)? ')';

# TransParam:
# 	type=('id' | 'name');

# QExp:
# 	qAttr=Qattribute comp=Comparison n=INT;

# Qattribute:
# 	type=('qa' | 'qb' | 'qc' | 'qd' | 'qe' | 'qf' | 'qg' | 'qh' | 'qi' | 'qj' | 'qk' | 'ql' | 'qm' | 'qn' | 'qo' | 'qp'
# 	| 'qq' | 'qr' | 'qs' | 'qt' | 'qu' | 'qv');

# Operator:
# 	op=('AND' | 'OR'| 'EXACT');

# Filter:
# 	'filter' '(' (filterExp=FilterExp)? (',' filterExps=FilterExp)? (',' 'size' ':' comp=Comparison exp=Expression) ')';

# FilterExp:
# 	filterkey=FilterKeyword ':' exp=Expression;

# Comparison:
# 	type=('==' | '>=' | '<=' | '<' | '>');

# FilterKeyword:
# 	type=('gte' | 'lte' | 'lt' | 'gt');

# // ------------------------------------------------------------
# ArtifactType:
# 	typeName=('Model' | 'Metamodel' | 'Dsl');

# // Object vars
# UserVar:
# 	UserParam ':' exp=Expression;

# WorkspaceVar:
# 	WorkspaceParam ':' exp=Expression;

# ProjectVar:
# 	ProjectParam ':' exp=Expression;

# MetamodelVar:
# 	MetamodelParam ':' exp=Expression;

# ModelVar:
# 	Param ':' exp=Expression;

# DslVar:
# 	Param ':' exp=Expression;

# // Object fields
# UserField:
# 	typeName=('id' | 'username' | 'email' | 'createdAt' | 'updatedAt');

# WorkspaceField:
# 	typeName=('id' | 'name' | 'description' | 'owner' | 'projects' | 'createdAt' | 'updatedAt');

# ProjectField:
# 	typeName=('id' | 'name' | 'description' | 'user' | 'workspace' | 'sharedUser' | 'comments' | 'createdAt' |
# 	'updatedAt');

# //ArtifactField:
# //	MetamodelField | ModelField | DslField
# //	;
# MetamodelField:
# 	typeName=('id' | 'accessControl' | 'description' | 'ePackage' | 'ext' | 'involvedOperations' | 'metrics' | 'models'
# 	| 'license' | 'metamodel' | 'name' | 'project' | 'size' | 'storageUrl' | 'type' | 'unique_name' | 'createdAt' |
# 	'updatedAt');

# ModelField:
# 	typeName=('id' | 'accessControl' | 'description' | 'ext' | 'involvedOperations' | 'license' | 'metamodel' | 'name' |
# 	'project' | 'size' | 'storageUrl' | 'type' | 'unique_name' | 'createdAt' | 'updatedAt');

# DslField:
# 	typeName=('id' | 'accessControl' | 'description' | 'ext' | 'involvedOperations' | 'license' | 'name' | 'project' |
# 	'size' | 'storageUrl' | 'type' | 'unique_name' | 'createdAt' | 'updatedAt');

# // Object Params 
# UserParam:
# 	typeName=('username' | 'userId' | 'email');

# WorkspaceParam:
# 	typeName=('owner' | 'workspaceId');

# ProjectParam:
# 	typeName=('username' | 'userId' | 'workspaceId' | 'projectId');

# //ArtifactParam:
# //	MetamodelParam ; // | DslParam;	
# MetamodelParam:
# 	MetaParam | Param;

# MetaParam:
# 	'eClassifier' | 'ePackageName' | 'ePackageNsURI' | 'ePackageNsPrefix' | 'quality-metric' | 'model';

# Param:
# 	'id' | 'accessControl' | 'description' | 'extension' | 'operation' | 'name' | 'unique-name' | 'project' | 'size';

# //DslParam:
# //	typeName=('id' | 'accessControl' | 'description' | 'ext' | 'operation' | 'name'| 'unique-name' | 'project'| 'size' );	
# //--------------------------------------------
# Variable:
# 	'var' name=ID '=' expression=Expression;

# Expression:
# 	{IntConstant} value=INT |
# 	{StringConstant} value=STRING |
# 	{BoolConstant} value=('true' | 'false') |
# 	{VariableRef} variable=[Variable];
